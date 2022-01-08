package com.demo.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dsc-f-nacos-server")
public interface NacosServerService {
    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);
}
