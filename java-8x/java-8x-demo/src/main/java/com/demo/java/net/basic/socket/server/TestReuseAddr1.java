package com.demo.java.net.basic.socket.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * SO_REUSEADDR选项
 * 
 * @author liuxilin
 * @date 2018/5/13 7:46
 */
public class TestReuseAddr1 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket1 = new ServerSocket(1234);
        System.out.println(serverSocket1.getReuseAddress());

        ServerSocket serverSocket2 = new ServerSocket();
        serverSocket2.setReuseAddress(true); // 预期是不报错, 但实际设置了也无法绑定同一个端口
        serverSocket2.bind(new InetSocketAddress(1234));

        ServerSocket serverSocket3 = new ServerSocket();
        serverSocket3.setReuseAddress(true);
        serverSocket3.bind(new InetSocketAddress(1234));
    }
}