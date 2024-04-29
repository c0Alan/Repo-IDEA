package com.demo.java.net.old;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 测试关闭服务端连接
 *
 * @author liuxilin
 * @date 2018/5/12 21:26
 */
public class Server03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            // 客户端一连上就断开
            socket.close();
        }
    }

    @Test
    public void state() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        // 处于活动状态!
        if (serverSocket.isBound() == true && serverSocket.isClosed() == false) {
            System.out.println("serverSocket处于活动状态!");
        } else {
            System.out.println("serverSocket处于非活动状态!");
        }
        serverSocket.accept();
    }
}