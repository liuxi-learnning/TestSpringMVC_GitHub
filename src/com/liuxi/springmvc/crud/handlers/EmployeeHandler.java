package com.liuxi.springmvc.crud.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.liuxi.springmvc.crud.dao.DepartmentDao;
import com.liuxi.springmvc.crud.dao.EmployeeDao;
import com.liuxi.springmvc.crud.entities.Employee;
import com.liuxi.springmvc.exceptions.UserNameNotMatchPasswordException;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;
    
    @ModelAttribute
    public void getEmployee(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
        if(id != null) {
            //s あ模拟从数据库取得一个employee
            Employee employee = employeeDao.get(id);
            map.put("employee", employee);
        }
    }
    
    /**
     * 1.@ExceptionHandler方法入参中可以闯入Exception对象，获取异常
     * 2.s入参中不能传入map，如果需要讲错误信息带到页面，需要ModelAndView作为返回值
     * 3.@ExceptionHandler有优先级问题，就近原则
     * 4.s如果Handler中找不到@ExceptionHandler标记的方法处理异常，
     * 则去@ControllerAdvice标记的类中寻找@ExceptionHandler标记的方法来处理
     * @param i
     * @return
     */
    //s如果想把错误信息带到页面，则需要返回modelandview
//    @ExceptionHandler({ArithmeticException.class})
//    //public String handleArithmeticException(Exception e) {
//    public ModelAndView handleArithmeticException(Exception e) {
//        ModelAndView mv = new ModelAndView("error");
//        System.out.println("arithmetic exception...");
//        System.out.println(e);
//        mv.addObject("exception", e);
//        //return "error";
//        return mv;
//    }
    
    @RequestMapping(value="/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i) {
        String[] strs = new String[10];
        System.out.println("testSimpleMappingExceptionResolver");
        System.out.println(strs[i]);
        return "success";
    }
    
    @RequestMapping(value="/testDefaultHandlerExceptionResolver", method=RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver() {
        System.out.println("testDefaultHandlerExceptionResolver");
        return "success";
    }
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="do 404 test")
    //s方法上标注@ResponseStatus以后，一定会按照其指定的statuscode显示的
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") Integer i) {
        if(i==0) {
            System.out.println("error!");
            throw new UserNameNotMatchPasswordException();
        }
        return "success";
    }
    
    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") Integer i) {
        System.out.println("result :" + 10/i);
        return "error";
    }
    
    @RequestMapping("testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file ) throws IOException {
        System.out.println("desc :" + desc);
        System.out.println("filename :" + file.getOriginalFilename());
        System.out.println("file input stream" + file.getInputStream());
        return "success";
    }
    
    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String val = messageSource.getMessage("i18n.username", null, locale);
        System.out.println(val); 
        return "i18n";
    }
    
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        
        byte[] body = null;
        InputStream in = session.getServletContext().getResourceAsStream("/input.jsp");
        body = new byte[in.available()];
        in.read(body);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-Disposition", "attachment;filename=input.jsp");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
        return response;
    }
    
    
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println("test HttpMessageConverter");
        System.out.println(body);
        return "hello , " + LocalDateTime.now();
    }
    
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        System.out.println("test response body");
        return employeeDao.getAll();
    }
    
    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee){
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    
    @RequestMapping(value="/emp/{id}", method=RequestMethod.PUT)
    //public String emp(@Valid Employee employee) {
    public String emp(Employee employee) {
        System.out.println("in employeeHandler, update a employee...");
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    
    @RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
    public String emp(@PathVariable ("id") Integer id, Map<String, Object> map) {
        System.out.println("in employeeHandler, redirect to update employee...");
        map.put("employee", employeeDao.get(id));
        map.put("departmentList", departmentDao.getDepartments());
        return "forward:/input.jsp";
    }
    
    @RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("in employeeHandler, DELETE");
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    
    @RequestMapping(value="/emp", method=RequestMethod.POST)
    public String save(Employee employee, BindingResult result) {
        if(result.getErrorCount() > 0) {
            System.out.println("NG!");
            for(FieldError err : result.getFieldErrors()) {
                System.out.println(err.getField() + "---" + err.getDefaultMessage());
            }
        }
        System.out.println("in employeeHandler, POST" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    
//    @InitBinder
//    public void intBander(WebDataBinder binder) {
//        //s让lastName不进行赋值。应用场景：用户权限往往是一个集合，单个的ID无法映射成一个集合，需要手动特殊处理
//        binder.setDisallowedFields("lastName");
//    }
    
    @RequestMapping(value="/emp", method=RequestMethod.GET)
    public String emp(Map<String, Object> map) {
        System.out.println("in employeeHandler, GET");
        map.put("departmentList", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "forward:/input.jsp";
    }
    
    @RequestMapping("/emps")
    public String emps(Map<String, Object> map) {
        map.put("employeeList", employeeDao.getAll());
        return "forward:/views/list.jsp";
    }
}
