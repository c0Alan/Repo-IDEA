package com.demo.springcloud.controller;

import com.demo.springcloud.response.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sentinel接口示例
 * 参考：https://blog.csdn.net/qq_59308271/article/details/140360067
 *
 * @author liuxl
 * @date 2024/11/6
 */
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
