package com.liuxi.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuxi.springmvc.crud.dao.DepartmentDao;
import com.liuxi.springmvc.crud.dao.EmployeeDao;
import com.liuxi.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    
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
