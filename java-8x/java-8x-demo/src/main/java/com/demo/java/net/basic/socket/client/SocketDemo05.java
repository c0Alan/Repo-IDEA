package com.demo.java.net.basic.socket.client;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketDemo05 {

    /**
     * 测试超时
     * 如果将超时时间设为0，则不使用超时时间；
     * 也就是说，客户端什么时候和服务器断开，将完全取决于服务端程序的超时设置
     */
    @Test
    public void timeout() {
        long time1 = 0, time2 = 0;
        Socket socket = new Socket();
        try {
            time1 = System.currentTimeMillis();
            // www.baidu.com 80 3000 5000 // 读取数据超时
            // 192.168.18.24 80 3000 5000 // 连接超时
            socket.connect(new InetSocketAddress("www.baidu.com", 80), 3000);
            socket.setSoTimeout(5000);
            time1 = System.currentTimeMillis();
            socket.getInputStream().read();
        } catch (SocketTimeoutException e) {
            if (!socket.isClosed() && socket.isConnected())
                System.out.println("读取数据超时!");
            else
                System.out.println("连接超时");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        }
    }
}
