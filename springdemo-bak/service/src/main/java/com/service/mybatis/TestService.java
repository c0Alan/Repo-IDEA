package com.service.mybatis;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test(){
        System.out.println("hello");
        return "hello";
    }
}
