package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * websocket 广播消息
 * 我们预期的效果是:当一个浏览器发送一个消息到服务端时，其他浏览器也能接收到从服务端发送来的这个消息。
 *
 * @author liuxilin
 * @date 2018/6/12 22:10
 */
@SpringBootApplication
public class Ch76Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch76Application.class, args);
    }
}
