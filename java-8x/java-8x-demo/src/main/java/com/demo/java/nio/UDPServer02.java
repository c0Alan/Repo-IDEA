package com.demo.java.nio;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * UDP协议
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class UDPServer02 {

    public final static int PORT = 7;
    public final static int MAX_PACKET_SIZE = 65507;

    /**
     * 实现客户端echo功能
     * nc -u localhost 7
     *
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
                ByteBuffer byteBuffer = buffer.duplicate();
                System.out.println(client + " write " + byteBuffer.getInt());
                byteBuffer.clear();
                channel.send(buffer, client);
                buffer.clear();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}