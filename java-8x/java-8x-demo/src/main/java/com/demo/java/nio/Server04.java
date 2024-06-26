package com.demo.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 接收来自客户端的消息并打印
 *
 * @author liuxl
 * @date 2024/5/4
 */
public class Server04 {

    private static final int BUF_SIZE = 1024;
    private static final int PORT = 9999;
    private static final int TIMEOUT = 3000;


    public static void main(String[] args) {
        selector();
    }

    public static void handleAccept(SelectionKey key) throws IOException {
        System.out.println("Accepted connection from " + key.channel());
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false); // 设置成非阻塞模式
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    public static void handleRead(SelectionKey key) throws IOException {
        System.out.println("Handling read");
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if (bytesRead == -1) {
            sc.close();
        }

        key.interestOps(SelectionKey.OP_WRITE);
    }

    public static void handleWrite(SelectionKey key) throws IOException {
        System.out.println("Handling write");
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.put("hello world!".getBytes("UTF-8"));
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        buf.compact();
        key.interestOps(SelectionKey.OP_READ);
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open(); // 打开ServerSocketChannel
            ssc.socket().bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false); // 设置成非阻塞模式
            ssc.register(selector, SelectionKey.OP_ACCEPT); // 将Channel注册到Selector上

            /** 与Selector一起使用时，Channel必须处于非阻塞模式下。 */
            /** 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。*/

            while (true) { // 监听新进来的连接
                if (selector.select(TIMEOUT) == 0) {
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    if (key.isWritable() && key.isValid()) {
                        handleWrite(key);
                    }
                    if (key.isConnectable()) {
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (selector != null) {
                try {
                    selector.close();
                    if (ssc != null) {
                        ssc.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
