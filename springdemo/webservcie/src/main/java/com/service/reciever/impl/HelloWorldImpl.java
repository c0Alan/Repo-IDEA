package com.service.reciever.impl;

import com.service.reciever.HelloWorld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld {
 
    public String sayHello(String sb) {
        // TODO Auto-generated method stub
        return "Hello world," +sb;
    }
 
}