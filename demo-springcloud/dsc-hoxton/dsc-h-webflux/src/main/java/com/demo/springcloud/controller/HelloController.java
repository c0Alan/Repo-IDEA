package com.demo.springcloud.controller;


import com.demo.springcloud.entity.User;
import com.demo.springcloud.util.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/helloService")
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String serverIp = NetUtil.getServerIpList();
        log.info("serverIp: " + serverIp + ",invoked hello，name = " + name);
        return "serverIp: " + serverIp + ",hello " + name;
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

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setUsername("李白");
        user.setAge(28);
        return Mono.just(user);
    }
}
