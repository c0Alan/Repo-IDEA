package com.webservice.receiver.impl;

import com.webservice.receiver.HelloWorld;
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