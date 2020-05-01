package com.liuxi.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldHandler {
    //only add some comment
    private static final String SUCCESS = "success";
    
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
