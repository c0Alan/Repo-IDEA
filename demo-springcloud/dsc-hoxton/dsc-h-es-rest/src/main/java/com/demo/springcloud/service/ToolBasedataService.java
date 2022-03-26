package com.demo.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.remote-service.dsc-h-tool.basedata-service}")
public interface ToolBasedataService {

    @GetMapping("/getRandomDataList")
    Map getRandomDataList(@RequestParam String configFile, @RequestParam int size);

}
