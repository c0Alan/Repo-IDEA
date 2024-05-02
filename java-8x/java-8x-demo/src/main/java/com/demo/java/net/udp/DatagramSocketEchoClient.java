package com.demo.java.net.udp;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramSocketEchoClient {

    public final static int PORT = 9000;

    /**
     * 通过一个无限循环读取用户输入的每一行数据。每一行数据都存储在 theLine 中。
     * 如果一行数据只包含一个点号( .) ，则表示用户结束输入，此时要退出循环。
     *
     */
    public static void main(String[] args) {

        String hostname = "localhost";
        if (args.length > 0) {
            hostname = args[0];
        }

        try {
            InetAddress ia = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket(PORT);
            DatagramSocketSenderThread sender = new DatagramSocketSenderThread(socket, ia, PORT);
            sender.start();
            Thread receiver = new DatagramSocketReceiverThread(socket);
            receiver.start();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (SocketException ex) {
            System.err.println(ex);
        }
    }
}