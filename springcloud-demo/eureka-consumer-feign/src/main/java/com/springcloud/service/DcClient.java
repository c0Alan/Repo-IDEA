package com.springcloud.service;

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

    /**
     * 通过 @GetMapping("/dc") 映射到 eureka-client 中对应的映射方法中
     * @return
     */
    @GetMapping("/dc")
    String consumer();

}