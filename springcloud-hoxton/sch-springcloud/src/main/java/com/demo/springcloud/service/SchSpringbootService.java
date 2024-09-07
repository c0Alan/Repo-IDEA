package com.demo.springcloud.service;

import com.demo.springcloud.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * sch-springboot 模块服务类
 * @author liuxl
 * @date 2024/8/31
 */
@FeignClient(value = "sch-springboot")
public interface SchSpringbootService {

    /**
     * 传入请求头
     * @param requestId
     * @return
     */
    @GetMapping("/demo/asyncMethod")
    ResponseResult<String> asyncMethod(@RequestHeader("requestId") String requestId);

}
