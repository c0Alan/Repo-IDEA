package com.demo.springcloud.controller;

import com.demo.springcloud.utils.NetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试按路径配置feign service")
@Slf4j
@RequestMapping("/feign")
@RestController
public class FeignController {
    
    @ApiOperation(value = "hello方法", notes = "hello方法")
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String serverIp = NetUtil.getServerIpList();
        log.info("serverIp: " + serverIp + ",invoked hello feign，name = " + name);
        return "serverIp: " + serverIp + ",hello feign " + name;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        log.info("invoked hello2 feign，name = " + name);
        return "hello2 feign " + name;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam String name) {
        log.info("invoked hello3 feign，name = " + name);
        return "hello3 feign " + name;
    }
}
