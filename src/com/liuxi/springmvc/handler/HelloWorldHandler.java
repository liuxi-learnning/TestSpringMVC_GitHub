package com.liuxi.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuxi.springmvc.entity.User;

@Controller
public class HelloWorldHandler {
    //only add some comment
    private static final String SUCCESS = "success";
    
    
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
