package com.sch.controller;

import com.sch.util.NetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "测试微服务调用服务端")
@RestController
@Slf4j
@RequestMapping("/helloService")
public class HelloController {
    
    @ApiOperation(value = "hello方法", notes = "hello方法")
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String serverIp = NetUtil.getServerIpList();
        log.info("sch-demo serverIp: " + serverIp + ",invoked hello，name = " + name);
        return " sch-demo serverIp: " + serverIp + ",hello " + name;
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

    @GetMapping("/hello4")
    public String hello4(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        log.info("invoked hello4，client ip = " + clientIp);
        return "hello4 " + clientIp;
    }
}
