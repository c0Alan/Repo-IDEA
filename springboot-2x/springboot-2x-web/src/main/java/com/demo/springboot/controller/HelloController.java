package com.demo.springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags= "helloworld")
@RestController
public class HelloController {

    @GetMapping ("/hello")
    public String index() {
        return "Hello World";
    }

}