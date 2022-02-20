package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * kafka 异步消息回调类
 *
 * @author liuxilin
 * @date 2022/2/20 19:53
 */
@Slf4j
public class KafkaFutureCallback implements ListenableFutureCallback<SendResult> {

    @Override
    public void onFailure(Throwable ex) {
        log.error("send kafka failed: {}", ex);
    }

    @Override
    public void onSuccess(SendResult result) {
        log.info("send kafka success: {}", result.getProducerRecord());
    }
}