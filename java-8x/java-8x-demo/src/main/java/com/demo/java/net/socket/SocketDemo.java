package com.demo.java.net.socket;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * socket 连接示例
 *
 * @author liuxilin
 * @date 2022/8/10 22:28
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {

    }

    /**
     * serverSocket.setSoTimeout 服务器连接等待超时时间设置,0则永久等待
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        int timeout = 3000;
//        int timeout = 0;

        serverSocket.setSoTimeout(timeout);
        System.out.println((timeout > 0) ? "accept方法将在" + serverSocket.getSoTimeout() + "毫秒后抛出异常！" : "accept方法永远阻塞！");
        serverSocket.accept();
    }

    /**
     * 获取当前时间
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        // 时间服务器
        try (Socket s = new Socket("time-a.nist.gov", 13);
             Scanner in = new Scanner(s.getInputStream(), "UTF-8")) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
