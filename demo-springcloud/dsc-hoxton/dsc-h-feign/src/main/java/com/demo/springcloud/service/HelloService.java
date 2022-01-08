package com.demo.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dsc-h-service-server")
public interface HelloService {
    @RequestMapping(value = "/helloService/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
