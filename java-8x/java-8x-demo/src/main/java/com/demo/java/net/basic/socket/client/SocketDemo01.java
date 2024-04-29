package com.demo.java.net.basic.socket.client;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * Socket 连接测试
 *
 * @author liuxl
 * @date 2018/5/11 12:59
 */
public class SocketDemo01 {
    private static final Logger logger = Logger.getLogger(SocketDemo01.class);

    /**
     * 简单的socket连接测试
     */
    @Test
    public void connect() {
        try {
            Socket socket = new Socket("www.baidu.com", 80); // 连接成功!
            logger.info("连接成功!");
        } catch (IOException e) {
            logger.error(e);
        }

        try {
            Socket socket = new Socket("127.0.0.1", 21); // 20: Connection refused, 21: 连接成功!
            logger.info("连接成功!");
        } catch (IOException e) {
            logger.error(e);
        }

//        try {
//            Socket socket = new Socket("192.168.10.10", 80); // Connection timed out
//            logger.info("连接成功!");
//        } catch (IOException e) {
//            logger.error(e);
//        }
    }

    /**
     * 判断一台主机有哪些端口被打开
     * 必须用 main, 用 Test模式不会打印任何线程信息
     */
    @Test
    public void listOpenPort() {
        int minPort = 8000;
        int maxPort = 8100;
        int threadCount = 10;
        int portIncrement = ((maxPort - minPort + 1) / threadCount)
                + (((maxPort - minPort + 1) % threadCount) == 0 ? 0 : 1);
        SocketThreadDemo1[] instances = new SocketThreadDemo1[threadCount];
        for (int i = 0; i < threadCount; i++) {
            instances[i] = new SocketThreadDemo1(minPort + portIncrement * i, minPort
                    + portIncrement - 1 + portIncrement * i);
            instances[i].start();
        }
    }

}
