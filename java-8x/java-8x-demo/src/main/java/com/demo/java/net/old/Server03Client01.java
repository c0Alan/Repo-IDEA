package com.demo.java.net.old;

import java.net.Socket;

class Server03Client01 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1234);
        Thread.sleep(1000);
        // socket.getOutputStream().write(1);
//        read() = -1
//        isConnected() = true
//        isClosed() = false
        System.out.println("read() = " + socket.getInputStream().read());
        System.out.println("isConnected() = " + socket.isConnected());
        System.out.println("isClosed() = " + socket.isClosed());
    }
}