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
                logger.error(e);
            }
        }
    }


}
