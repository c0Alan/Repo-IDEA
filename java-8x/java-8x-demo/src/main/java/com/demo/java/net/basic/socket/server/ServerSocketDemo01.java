package com.demo.java.net.basic.socket.server;

import org.junit.Test;

import java.net.ServerSocket;

public class ServerSocketDemo01 {

    /**
     * 获取已经分配了的端口
     */
    @Test
    public void getOpenedPort() {
        int minPort = 10, maxPort = 1000;
        for (int port = minPort; port <= maxPort; port++)
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (Exception e) {
                System.err.println(e.getClass());
                System.err.println("端口" + port + "已经打开!");
            }
    }
}
