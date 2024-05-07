package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(value="GatewayController",tags={"gateway网关测试接口"})
@RestController
public class GatewayController {
    @GetMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
