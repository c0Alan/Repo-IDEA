package com.demo.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }
}
