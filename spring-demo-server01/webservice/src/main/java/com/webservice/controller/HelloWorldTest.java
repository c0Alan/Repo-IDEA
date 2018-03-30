package com.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldTest {
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "success";
    }
}
