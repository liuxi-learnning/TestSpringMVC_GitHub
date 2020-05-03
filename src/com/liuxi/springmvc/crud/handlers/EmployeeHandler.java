package com.liuxi.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuxi.springmvc.crud.dao.EmployeeDao;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    
    @RequestMapping("/emps")
    public String emps(Map<String, Object> map) {
        map.put("employeeList", employeeDao.getAll());
        return "forward:/views/list.jsp";
    }
}
