package com.demo.springcloud.controller;

import com.demo.springcloud.service.EtcdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Api(tags = "Etcd服务接口")
@RestController
@Slf4j
@RequestMapping("/etcd")
public class EtcdController {
    @Autowired
    EtcdService etcdService;
    
    @ApiOperation(value = "getValue方法", notes = "getValue方法")
    @GetMapping("/getValue")
    public String getValue(@RequestParam String name) throws ExecutionException, InterruptedException {
        String result = etcdService.getValue(name);
        log.info("result: {}", result);
        return result;
    }
}
