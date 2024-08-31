package com.demo.springcloud.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * sse 消息发送模拟器
 *
 * @author liuxl
 * @date 2024/8/28
 */
@Slf4j
@Component
public class SseProducer {

    @Autowired
    private SseEmitters emitters;

    //    @Scheduled(fixedRate = 3000)
    public void publish() {
        log.info("sse 发布消息");
        emitters.send("hello, this is sse message");
    }


}
