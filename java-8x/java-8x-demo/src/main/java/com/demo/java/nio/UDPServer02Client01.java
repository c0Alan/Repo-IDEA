package com.demo.java.nio;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

/**
 * UDPServer02 的 客户端
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class UDPServer02Client01 {

    public final static int PORT = 7;
    private final static int LIMIT = 100;

    /**
     * 连接 UDPServer02 服务端，读写 0 到 99 的数字
     * @param args
     */
    public static void main(String[] args) {

        SocketAddress remote;
        try {
            remote = new InetSocketAddress("localhost", PORT);
        } catch (RuntimeException ex) {
            System.err.println("Usage: java UDPEchoClientWithChannels host");
            return;
        }

        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.configureBlocking(false);
            channel.connect(remote);

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            ByteBuffer buffer = ByteBuffer.allocate(4);
            int n = 0;
            int numbersRead = 0;
            while (true) {
                if (numbersRead == LIMIT) {
                    break;
                }
                // wait one minute for a connection
                selector.select(60000);
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                if (readyKeys.isEmpty() && n == LIMIT) {
                    // All packets have been written and it doesn't look like any
                    // more are will arrive from the network
                    break;
                } else {
                    Iterator<SelectionKey> iterator = readyKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = (SelectionKey) iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            buffer.clear();
                            channel.read(buffer);
                            buffer.flip();
                            int echo = buffer.getInt();
                            System.out.println("Read: " + echo);
                            numbersRead++;
                        }
                        if (key.isWritable()) {
                            buffer.clear();
                            buffer.putInt(n);
                            buffer.flip();
                            channel.write(buffer);
                            System.out.println("Wrote: " + n);
                            n++;
                            if (n == LIMIT) {
                                // All packets have been written; switch to read-only mode
                                key.interestOps(SelectionKey.OP_READ);
                            }
                        }
                    }
                }
            }
            System.out.println("Echoed " + numbersRead + " out of " + LIMIT +
                    " sent");
            System.out.println("Success rate: " + 100.0 * numbersRead / LIMIT +
                    "%");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}