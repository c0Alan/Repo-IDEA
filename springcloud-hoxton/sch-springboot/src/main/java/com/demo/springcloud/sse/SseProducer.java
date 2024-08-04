package com.demo.springcloud.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SseProducer {

    @Autowired
    private SseEmitters emitters;

    @Scheduled(fixedRate = 3000)
    public void publish() {
        log.info("publish");
        emitters.send("hello world");
    }


}
