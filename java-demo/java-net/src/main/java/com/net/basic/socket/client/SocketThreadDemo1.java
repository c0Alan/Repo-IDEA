package com.net.basic.socket.client;

import org.apache.log4j.Logger;

import java.net.Socket;

public class SocketThreadDemo1 extends Thread {
    private static final Logger logger = Logger.getLogger(SocketThreadDemo1.class);

    private int minPort, maxPort;


    public SocketThreadDemo1(int minPort, int maxPort) {
        this.minPort = minPort;
        this.maxPort = maxPort;
    }

    public void run() {
        for (int i = minPort; i <= maxPort; i++) {
            try {
                Socket socket = new Socket("127.0.0.1", i);
                logger.info(String.valueOf(i) + ":ok");
                socket.close();
            } catch (Exception e) {
//                logger.error(e);
            }
        }
    }

    /**
     * 判断一台主机有哪些端口被打开
     */
    public static void main(String[] args)
    {
        int minPort = 8000, maxPort = 8100;
        int threadCount = 10;
        int portIncrement = ((maxPort - minPort + 1) / threadCount)
                + (((maxPort - minPort + 1) % threadCount) == 0 ? 0 : 1);
        SocketThreadDemo1[] instances = new SocketThreadDemo1[threadCount];
        for (int i = 0; i < threadCount; i++)
        {
            instances[i] = new SocketThreadDemo1(minPort + portIncrement * i, minPort
                    + portIncrement - 1 + portIncrement * i);
            instances[i].start();
        }
    }
}
