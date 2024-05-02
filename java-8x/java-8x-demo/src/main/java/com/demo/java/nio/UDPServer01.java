package com.demo.java.nio;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * UDP 协议服务
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class UDPServer01 {

    public final static int PORT = 9;
    public final static int MAX_PACKET_SIZE = 65507;

    /**
     * 记录发送数据的主机以及所发送的数据。
     * nc -u localhost 9
     * @param args
     */
    public static void main(String[] args) {

        try {
            DatagramChannel channel = DatagramChannel.open();
            DatagramSocket socket = channel.socket();
            SocketAddress address = new InetSocketAddress(PORT);
            socket.bind(address);
            ByteBuffer buffer = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);
            while (true) {
                SocketAddress client = channel.receive(buffer);
                buffer.flip();
                System.out.print(client + " says ");
                while (buffer.hasRemaining()) {
                    System.out.write(buffer.get());
                }
                System.out.println();
                buffer.clear();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}