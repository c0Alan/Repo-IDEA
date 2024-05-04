package com.demo.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
 
public class Server04Client02 {
    public static void main(String[] args) {
        try {
            // 打开 SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
 
            // 设置为非阻塞模式
            socketChannel.configureBlocking(false);
 
            // 连接到服务器
            socketChannel.connect(new InetSocketAddress("localhost", 9999));
 
            // 等待连接完成
            while (!socketChannel.finishConnect()) {
                // 可以在这里做其他事情，不阻塞
            }
 
            // 发送数据
            String message = "Hello, Server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
 
            // 接收数据
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int bytesRead = socketChannel.read(readBuffer);
 
            while (bytesRead != -1) {
                readBuffer.flip();
                while (readBuffer.hasRemaining()) {
                    System.out.print((char) readBuffer.get());
                }
                readBuffer.clear();
                bytesRead = socketChannel.read(readBuffer);
            }
 
            // 关闭 SocketChannel
            socketChannel.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}