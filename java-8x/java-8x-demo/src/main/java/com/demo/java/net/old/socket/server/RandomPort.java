package com.demo.java.net.old.socket.server;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Random;

/**
 * 获取ServerSocket信息的方法及FTP原理
 * 
 * @author liuxilin
 * @date 2018/5/12 21:33
 */
public class RandomPort {

    /**
     * ServerSocket对象未绑定端口，getLocalPort方法的返回值为-1。
     * ServerSocket对象绑定了一个固定的端口，getLocalPort方法返回这个固定端口。
     * ServerSocket对象的绑定端口为0，getLocalPort方法返回一个随机的端口（这类端口被称为匿名端口）。
     * @throws Exception
     */
    @Test
    public void getLocalPort() throws Exception {
        for (int i = 1; i <= 5; i++) {
            System.out.print("Random Port" + i + "：");
//            Random Port1：12342
//            Random Port2：12343
//            Random Port3：12344
//            Random Port4：12345
//            Random Port5：12346
            System.out.println(new ServerSocket(0).getLocalPort());
        }
    }

    /**
     * 得到ServerSocket对象绑定的IP地址。
     * 如果ServerSocket对象未绑定IP地址，返回0.0.0.0
     * @throws Exception
     */
    @Test
    public void getInetAddress() throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.6.1", 0));

        System.out.println(serverSocket.getInetAddress().getHostAddress());
        System.out.println(serverSocket.getLocalPort());
    }

    /**
     * 这个方法其实是将getLocalPort和getInetAddress方法的功能集成到了一起
     * @throws Exception
     */
    @Test
    public void getLocalSocketAddress() throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.6.1", 1234));
        System.out.println(serverSocket.getLocalSocketAddress());
        InetSocketAddress nsa = (InetSocketAddress)serverSocket.getLocalSocketAddress();
        System.out.println( nsa.getAddress().getHostAddress());
        System.out.println( nsa.getPort());
    }
}