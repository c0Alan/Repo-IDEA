package com.demo.springcloud.controller;

import com.demo.springcloud.remote.WebFeignService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试feign调用,服务名uri2")
@RestController
@Slf4j
@RequestMapping("/web2")
public class WebFeignController {

    @Autowired
    WebFeignService webFeignService;

    @GetMapping("/feign")
    public String hello(@RequestParam String name) {
        String result = webFeignService.hello(name);
        return result;
    }

}
