package com.springcloud.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 定义 eureka-client 服务的客户端
 *
 * @author liuxl
 * @date 2018/4/12 7:37
 */
@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();

}