package com.net.basic.socket.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * SO_RCVBUF选项
 *
 * @author liuxilin
 * @date 2018/5/13 7:55
 */
public class TestReceiveBufferSize {

    /**
     * 执行如下三个命令 (192.168.18.100为本机IP地址)：
     * telnet 192.168.18.100 1234
     * telnet localhost 1234
     * telnet 192.168.18.100 1234
     *
     * 运行结果：
     * serverSocket:2048
     * socket:2048
     * serverSocket:2048
     * socket:1024
     * serverSocket:2048
     * socket:2048
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        serverSocket.setReceiveBufferSize(2048); // 将接收缓冲区设为2K
        while (true) {
            Socket socket = serverSocket.accept();
            // 如果客户端请求使用的是本地IP地址，重新将Socket对象的接
            // 收缓冲区设为1K            
            if (socket.getInetAddress().isLoopbackAddress())
                socket.setReceiveBufferSize(1024);
            System.out.println("serverSocket:"
                    + serverSocket.getReceiveBufferSize());
            System.out.println("socket:" + socket.getReceiveBufferSize());
            socket.close();
        }
    }
}