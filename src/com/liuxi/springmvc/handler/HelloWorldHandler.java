package com.liuxi.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldHandler {
    
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("first controller");
        return "success";
    }
}
