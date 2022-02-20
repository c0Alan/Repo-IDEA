package com.demo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author liuxilin
 * @date 2022/2/20 19:36
 */
@Slf4j
@RestController
public class KafkaConsumerContoller {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @Autowired
    private ConsumerFactory consumerFactory;

    @GetMapping("/stop")
    public String stop(){
        registry.getListenerContainer("forward").pause();
        return "success";
    }

    @GetMapping("/start")
    public String start(){
       //判断监听容器是否启动，未启动则将其启动
        if (!registry.getListenerContainer("forward").isRunning()) {
            registry.getListenerContainer("forward").start();
        }
        registry.getListenerContainer("forward").resume();
        return "success";
    }

}
