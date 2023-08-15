package com.sch.remote.service;

/**
 * 参考：https://blog.csdn.net/forezp/article/details/81040965
 * @author liuxilin
 * @since 2023-08-13
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sch-demo")
public interface SchDemoService {
    @RequestMapping(value = "/helloService/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
