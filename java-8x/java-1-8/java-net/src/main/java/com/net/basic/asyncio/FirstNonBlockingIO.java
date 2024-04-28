package com.net.basic.asyncio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 一个非阻塞I/O的例子
 *
 * @author liuxilin
 * @date 2018/5/13 9:53
 */
public class FirstNonBlockingIO {
    /**
     * 访问新浪网，并将新浪网的首页在控制台上输出
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SocketAddress remote = new InetSocketAddress("www.sina.com.cn", 80);
        SocketChannel channel = SocketChannel.open(remote);
        String request = "GET / HTTP/1.1\r\n" +
                "Host:www.sina.com.cn\r\n" +
                "Connection:close\r\n\r\n";
        ByteBuffer header = ByteBuffer.wrap(request.getBytes());
        channel.write(header);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        WritableByteChannel out = Channels.newChannel(System.out);
        while (channel.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        channel.close();
    }
}