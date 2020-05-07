package com.liuxi.springmvc.crud.service;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    //springIOC容器中的bean不能引用springMVCIOC容器中的bean。但反过来是可以的
    //@Autowired
    //private HelloWorldHandler helloWorldHandler;
    public UserService() {
        System.out.println("user service constructor...");
    }
}
