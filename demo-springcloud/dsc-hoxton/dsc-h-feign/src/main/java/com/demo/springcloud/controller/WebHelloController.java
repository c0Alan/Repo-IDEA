package com.demo.springcloud.controller;

import com.demo.springcloud.service.WebHelloService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试feign调用,服务名uri1")
@RestController
@Slf4j
@RequestMapping("/web")
public class WebHelloController {

    @Autowired
    WebHelloService webHelloService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String result = webHelloService.hello(name);
        return result;
    }

}
