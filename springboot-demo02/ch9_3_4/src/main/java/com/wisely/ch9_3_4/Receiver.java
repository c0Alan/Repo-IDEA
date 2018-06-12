package com.springboot.ch9_3_4;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "my-destination") // 监听 my-destination 目的地发送的消息。
    public void receiveMessage(String message) {
        System.out.println("接受到: <" + message + ">");
    }

}
