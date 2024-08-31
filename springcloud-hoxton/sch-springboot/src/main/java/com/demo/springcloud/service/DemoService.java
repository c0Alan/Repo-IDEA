package com.demo.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * service 示例
 * @author liuxl
 * @date 2024/8/29
 */
@Slf4j
@Service
public class DemoService {

    @Async
    public void asyncMethod() {
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info("异步方法执行！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
