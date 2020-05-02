package com.liuxi.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuxi.springmvc.entity.User;

//@SessionAttributes注解，可以通过属性名（value）将模型属性放入会话，还可以通过对象类型（types）添加到会话
//@SessionAttributes(value= {"user"}, types= {String.class, LocalDateTime.class})
@Controller
public class HelloWorldHandler {
    //only add some comment
    private static final String SUCCESS = "success";
    
    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("testForward");
        return "forward:/index.jsp";
    }
    
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }
    
    @RequestMapping("/testView")
    public String testView() {
        System.out.println("testView");
        return "helloView";
    }
    
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }
    
    //@ModelAttribute标注的方法，springMVC会在每个目标方法执行之前被调用。
    /**
     *  流程
     *  s1，执行@ModelAttribute标注的方法，从数据库获取对象，put到map中，键为user
     *  s2，springMVC从map中获取User对象，并把表单中的请求参数赋值给User对象对应的属性
     *  s3，将上述对象传递给目标方法的参数
     *  注意，put到map的时候，参数名需要约定为目标参数类型首字母小写的变量
     *  或者，目标方法也使用@ModelAttribute去修饰入参
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id", required=false) String id, Map<String, Object> map) {
        if(id != null) {
            //s あ模拟从数据库取得一个user
            User user = new User("1", "jack", "123", "jack@test.com", 14);
            System.out.println("test get user form DB :  " + user);
            //map.put("user", user);
            map.put("u", user);
        }
    }
    
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("u") User user) {
        System.out.println("testModelAttribute, modify:  " + user);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testSessionAttribute")
    public String testSessionAttribute(Map<String, Object> map) {
        User user = new User("tom","123","tom@test.com",15);
        map.put("user", user);
        map.put("testString", "hello");
        map.put("testLocalDateTime", LocalDateTime.now());
        System.out.println("testSessionAttribute " );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("names", Arrays.asList("tom","jerry","mike"));
        System.out.println("testMap " );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time",  LocalDateTime.now());
        System.out.println("testModelAndView " );
        return modelAndView;
    }
    
    @RequestMapping(value="/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI " + request + ", " + response);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo " + user);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept-Language") String al) {
        System.out.println("testRequestHeader , accept language " + al);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testcookieValue")
    public String testcookieValue(@CookieValue(value="JSESSIONID") String sessionID) {
        System.out.println("testcookieValue , sessionID " + sessionID);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRequestParam")
    public String testRequestParam(@RequestParam(value="username") String username,
            @RequestParam(value="age", required=false, defaultValue="0") Integer age) {
        System.out.println("testRequestParam , username " + username  + " age " + age);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
    public String testPut(@PathVariable("id") Integer id) {
        System.out.println("testRest , GET " + id );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Integer id) {
        System.out.println("testRest , delete " + id );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest", method=RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest , POST " );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("testRest , GET " + id );
        return SUCCESS;
    }
    
    @RequestMapping(value="/testVariable/{id}")
    public String testVariable(@PathVariable("id") Integer id) {
        System.out.println("testVariable" + id + "jjj");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testParams", params= {"username", "age!=10"})
    public String testParams() {
        System.out.println("testParams");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testMethod", method=RequestMethod.POST)
    public String testMethod() {
        
        System.out.println("test method");
        return SUCCESS;
    }
    
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("first controller");
        return SUCCESS;
    }
}
