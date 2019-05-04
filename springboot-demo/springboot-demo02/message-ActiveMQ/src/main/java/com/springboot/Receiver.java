package com.springboot;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    /**
     * 监听 my-destination 目的地发送的消息。
     * @param message
     */
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接受到: <" + message + ">");
    }

    /**
     * 一条消息只能到达一一次, 同个目的地多个地方声明的话会被轮流接收
     */
    @JmsListener(destination = "my-destination")
    public void receiveMessage2(String message) {
        System.out.println("接受到2: <" + message + ">");
    }

}
