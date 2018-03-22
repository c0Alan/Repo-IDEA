package com.service.receiver.impl;

import com.service.receiver.HelloWorld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld {
 
    public String sayHello(String param) {
        // TODO Auto-generated method stub
        System.out.println(param);
        return "Hello world," + param;
    }
 
}