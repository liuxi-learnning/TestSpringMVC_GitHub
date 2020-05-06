package com.liuxi.springmvc.crud.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {
    
    //s在渲染视图之后被执行，可以释放资源
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("first, after....");
    }

    //s在目标方法执行之后，渲染视图之前被执行。可以对请求域中的属性或视图做出修改
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("first, post....");
    }

    //s返回true则继续执行后续的拦截器和目标方法，返回false则不会执行后续拦截器和目标方法
    //s可以考虑坐权限，日志，事务
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("first, pre....");
        return true;
    }

}
