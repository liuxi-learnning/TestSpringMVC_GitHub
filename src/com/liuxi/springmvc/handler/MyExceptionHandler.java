package com.liuxi.springmvc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    //public String handleArithmeticException(Exception e) {
    public ModelAndView handleArithmeticException(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        System.out.println("arithmetic exception...");
        System.out.println(e);
        mv.addObject("exception", e);
        //return "error";
        return mv;
    }
}
