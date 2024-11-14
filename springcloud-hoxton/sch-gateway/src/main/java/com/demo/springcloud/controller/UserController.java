package com.demo.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {


    //id 查询
    @GetMapping("/user/{id}")
    public Mono<String> geetUserId(@PathVariable int id) {
        return Mono.just("userId:" + id);
    }

}