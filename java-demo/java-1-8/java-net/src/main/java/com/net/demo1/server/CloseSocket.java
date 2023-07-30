package com.net.demo1.server;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1234);
        Thread.sleep(1000);
        // socket.getOutputStream().write(1);
//        read() = -1
//        isConnected() = true
//        isClosed() = false
        System.out.println("read() = " + socket.getInputStream().read());
        System.out.println("isConnected() = " + socket.isConnected());
        System.out.println("isClosed() = " + socket.isClosed());
    }
}

/**
 * 测试关闭服务端连接
 *
 * @author liuxilin
 * @date 2018/5/12 21:26
 */
public class CloseSocket {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            socket.close();
        }
    }

    @Test
    public void state() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        // 处于活动状态!
        if (serverSocket.isBound() == true && serverSocket.isClosed() == false)
            System.out.println("serverSocket处于活动状态!");
        else
            System.out.println("serverSocket处于非活动状态!");
//        serverSocket.accept();
    }
}