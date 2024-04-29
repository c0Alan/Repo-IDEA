package com.demo.java.net.old.socket.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SO_REUSEADDR选项
 * 如果多个ServerSocket对象同时绑定到一个端口上，
 * 那么当客户端向这个端口发出请求时，该由哪个ServerSocket对象来接收客户端请求呢
 * 当多个ServerSocket对象同时绑定一个端口时，系统会随机选择一个ServerSocket对象来接收客户端请求
 *
 * @author liuxilin
 * @date 2018/5/13 7:46
 */
public class TestReuseAddr2 extends Thread {
    String s;

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(1234));
            Socket socket = serverSocket.accept();
            System.out.println(s + "：" + socket);
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
        }
    }

    public TestReuseAddr2(String s) {
        this.s = s;
    }

    /**
     * 连续执行5次下面的命令：
     * telnet localhost 1234
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
            new TestReuseAddr2("ServerSocket" + i).start();
    }
}