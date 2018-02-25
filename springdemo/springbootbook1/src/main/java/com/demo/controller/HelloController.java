package com.demo.controller;

import com.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    public HelloController() {
        System.out.println("HelloController inited!");
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
        helloService.sayHello();
        return "hello.html";
    }
}
