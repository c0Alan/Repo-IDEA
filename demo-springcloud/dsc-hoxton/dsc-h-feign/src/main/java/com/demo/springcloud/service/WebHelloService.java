package com.demo.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.remote-service.dsc-h-web.service-name}/${app.remote-service.dsc-h-web.hello-uri}",
url = "${app.remote-service.dsc-h-web.url:}")
public interface WebHelloService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
