package com.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Value("${hello.msg}")
    private String msg;

    public String sayHello() {
        return msg;
    }
}
