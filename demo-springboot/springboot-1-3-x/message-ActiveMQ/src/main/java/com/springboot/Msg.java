package com.springboot;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 定义JMS 发送的消息需实现MessageCreator 接口，并重写其createMessage 方法:
 */
public class Msg implements MessageCreator {
    private String msg;

    public Msg(String msg) {
        this.msg = msg;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(msg);
    }

}
