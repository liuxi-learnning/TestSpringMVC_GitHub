package com.liuxi.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liuxi.springmvc.crud.dao.DepartmentDao;
import com.liuxi.springmvc.crud.dao.EmployeeDao;
import com.liuxi.springmvc.crud.entities.Employee;
import com.liuxi.springmvc.entity.User;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    
    @ModelAttribute
    public void getEmployee(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
        if(id != null) {
            //s あ模拟从数据库取得一个employee
            Employee employee = employeeDao.get(id);
            map.put("employee", employee);
        }
    }
    
    @RequestMapping(value="/emp/{id}", method=RequestMethod.PUT)
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
    public String save(Employee employee) {
        System.out.println("in employeeHandler, POST");
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    
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
