package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: ynz
 * @Date: 2018/12/30/030 15:13
 */
@Slf4j
@Component
public class KafkaForwardListener {

    /*@KafkaListener(id = "forward", topics = "q_dsc_test4", autoStartup = "false")
    @SendTo("q_dsc_test2")
    public String forward(String data) {
        log.info("接收到消息数量：{}",data);
        return "send msg : " + data;
    }*/
}
