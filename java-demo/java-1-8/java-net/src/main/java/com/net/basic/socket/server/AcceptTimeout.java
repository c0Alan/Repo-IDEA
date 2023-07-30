package com.net.basic.socket.server;

import java.net.ServerSocket;

/**
 * SO_TIMEOUT选项
 * 
 * @author liuxilin
 * @date 2018/5/13 8:33
 */
public class AcceptTimeout {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        int timeout = 3000;

        serverSocket.setSoTimeout(timeout);
        System.out.println((timeout > 0) ? "accept方法将在"
                + serverSocket.getSoTimeout() + "毫秒后抛出异常！" : "accept方法永远阻塞！");
        serverSocket.accept();
    }
}