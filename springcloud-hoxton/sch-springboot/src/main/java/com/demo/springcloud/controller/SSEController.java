package com.demo.springcloud.controller;

import com.demo.springcloud.sse.SSEServer;
import com.demo.springcloud.sse.SseEmitters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "sse接口")
@RestController
@RequestMapping("/sse")
public class SSEController {
    long i = -1;

    @Autowired
    private SseEmitters emitters;


    /**
     * 参考：https://blog.csdn.net/qq_16127313/article/details/138031054
     * @param userId
     * @return
     */
    @ApiOperation("初始化")
    @GetMapping(value = "/connect/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter connect(@PathVariable String userId) {
        if (i < 0) {
            new Thread(() -> sendMessage()).start();
        }
        return SSEServer.connect();
    }

    private void sendMessage() {
        // 保证仅触发一次
        if (i < 0) {
            log.info("Server-Sent Events start");
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                }
                i = ++i % 101;
                SSEServer.batchSendMessage(String.valueOf(i));
            }
        }
    }


    /**
     * 参考：https://blog.csdn.net/qq_42038565/article/details/136000281
     * @return
     */
    @GetMapping(path = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe() {
        log.info("前端订阅成功");
        return emitters.add(new SseEmitter());
    }
}
