package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试微服务调用服务端")
@RestController
@Slf4j
@RequestMapping("/helloService")
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked hello1，name = " + name);
        return "hello1 " + name;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        log.info("invoked hello2，name = " + name);
        return "hello2 " + name;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam String name) {
        log.info("invoked hello3，name = " + name);
        return "hello3 " + name;
    }
}
