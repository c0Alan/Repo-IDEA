package com.demo.java.net.old.socket.client;

import org.junit.Test;

import java.net.Socket;

/**
 * @author liuxilin
 * @date 2018/5/12 8:54
 */
public class SocketDemo03 {


    /**
     * 打印Socket对象的各种状态
     *
     * @throws Exception
     */
    @Test
    public void printState() throws Exception {
        Socket socket1 = null, socket2 = null;

//        socket1.isClosed():false
//        socket1.isConnected():true
//        socket1处于连接状态!
        socket1 = new Socket("www.ptpress.com.cn", 80);
        printState(socket1, "socket1");

//        socket1.isClosed():true
//        socket1.isConnected():true
//        socket1处于非连接状态!
        socket1.getOutputStream().close();
        printState(socket1, "socket1");

//        socket2.isClosed():false
//        socket2.isConnected():false
//        socket2处于非连接状态!
        socket2 = new Socket();
        printState(socket2, "socket2");

//        socket2.isClosed():true
//        socket2.isConnected():false
//        socket2处于非连接状态!
        socket2.close();
        printState(socket2, "socket2");

//        socket3.isInputShutdown:false
//        socket3.isOutputShutdown:false
//        socket3.isClosed:false
//        socket3.isConnected:true
        Socket socket3 = new Socket("www.ptpress.com.cn", 80);
        printState2(socket3, "socket3");

//        socket3.isInputShutdown:true
//        socket3.isOutputShutdown:false
//        socket3.isClosed:false
//        socket3.isConnected:true
        socket3.shutdownInput();
        printState2(socket3, "socket3");

//        socket3.isInputShutdown:true
//        socket3.isOutputShutdown:true
//        socket3.isClosed:false
//        socket3.isConnected:true
        socket3.shutdownOutput();
        printState2(socket3, "socket3");
    }

    public void printState(Socket socket, String name) {
        System.out.println(name + ".isClosed():" + socket.isClosed());
        System.out.println(name + ".isConnected():" + socket.isConnected());
        if (socket.isClosed() == false && socket.isConnected() == true)
            System.out.println(name + "处于连接状态!");
        else
            System.out.println(name + "处于非连接状态!");
        System.out.println();
    }

    public static void printState2(Socket socket, String name) {
        System.out.println(name + ".isInputShutdown:" + socket.isInputShutdown());
        System.out.println(name + ".isOutputShutdown:" + socket.isOutputShutdown());
        System.out.println(name + ".isClosed:" + socket.isClosed());
        System.out.println(name + ".isConnected:" + socket.isConnected());
        System.out.println();
    }
}
