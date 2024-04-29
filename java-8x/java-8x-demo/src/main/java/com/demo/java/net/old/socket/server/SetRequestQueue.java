package com.demo.java.net.old.socket.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket 设置请求队列的长度
 *
 * @author liuxilin
 * @date 2018/5/12 20:38
 */
class TestRequestQueue {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket("localhost", 1234);
            socket.getOutputStream().write(1);
            System.out.println("已经成功创建第" + String.valueOf(i + 1) + "个客户端连接!");
        }
    }
}

public class SetRequestQueue {
    public static void main(String[] args) throws Exception {
        int queueLength = 6;
        ServerSocket serverSocket = new ServerSocket(1234, queueLength);
        System.out.println("端口(1234)已经绑定，请按回车键开始处理客户端请求！");
        System.in.read();
        int n = 0;
        while (true) {
            System.out.println("<准备接收第" + (++n) + "个客户端请求！");
            Socket socket = serverSocket.accept();
            System.out.println("正在处理第" + n + "个客户端请求");
            Thread.sleep(3000);
            System.out.println("第" + n + "个客户端请求已经处理完毕!>");
        }
    }
}