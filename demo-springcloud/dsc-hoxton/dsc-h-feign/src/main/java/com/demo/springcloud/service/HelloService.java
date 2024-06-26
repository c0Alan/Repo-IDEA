package com.demo.springcloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.remote-service.dsc-h-service.service-name}",
url = "${app.remote-service.dsc-h-service.url:}")
public interface HelloService {
    @RequestMapping(value = "/helloService/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
