package com.springboot.domain;

/**
 * 服务端向浏览器发送的此类的消息:
 * 
 * @author liuxilin
 * @date 2018/6/12 22:02
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}