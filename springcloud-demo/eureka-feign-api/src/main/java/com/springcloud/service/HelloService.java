package com.springcloud.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试 api 依赖, 用于绑定 feign-client 和 feign-consumer 之间的映射
 *
 * @author liuxl
 * @date 2018/4/15 12:14
 */
public interface HelloService {

    /**
     * feign-client 和 feign-consumer 之间通过"/hello"映射绑定,
     * 不用再在自己的方法中加@GetMapping映射
     * @param name
     * @return
     */
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}