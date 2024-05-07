package com.demo.springcloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.remote-service.dsc-h-web.service-name}/${app.remote-service.dsc-h-web.feign-uri}",
url = "${app.remote-service.dsc-h-web.url:}")
public interface WebFeignService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
