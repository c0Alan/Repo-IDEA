package com.demo.springcloud.controller;

import com.demo.springcloud.response.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Sentinel接口示例")
@RestController
@Slf4j
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/hello")
    public ResponseResult hello(){
        return ResponseResult.success("测试直接限流!");
    }

}
