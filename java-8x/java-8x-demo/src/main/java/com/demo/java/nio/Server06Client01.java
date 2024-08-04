package com.demo.java.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 服务端、客户端双向读写
 *
 * @author liuxl
 * @date 2024/5/4
 */
@Slf4j
public class Server06Client01 {
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private SocketChannel socketChannel;
    private Selector selector;


    /**
     * 通过控制台写入消息
     */
    public static void main(String[] args) throws Exception {
        Server06Client01 server06Client01 = new Server06Client01("127.0.0.1", 8000);

        new Thread(() -> {
            try {
                server06Client01.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            server06Client01.sendToServer(next);
        }
    }

    public Server06Client01(String hostname, int port) throws IOException {
        // 打开socket通道
        socketChannel = SocketChannel.open();
        // 配置为非阻塞 即异步IO
        socketChannel.configureBlocking(false);
        // 连接服务器端
        socketChannel.connect(new InetSocketAddress(hostname, port));
        // 创建选择器
        selector = Selector.open();
        // 注册请求连接事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void start() throws IOException {
        log.info("Server06Client01 start");
        while (true) {
            int select = selector.select();
            if (select > 0) {
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) {
                        socketChannel.finishConnect();
                        //注册写操作
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("server connected...");
                    }
                    if (key.isReadable()) {
                        readBuffer.clear();
                        socketChannel.read(readBuffer);
                        System.out.println("server receive:" + new String(readBuffer.array(), 0, readBuffer.position()));
                    }
                }
            }
        }
    }

    public void sendToServer(String msg) throws IOException {
        writeBuffer.clear();
        writeBuffer.put(msg.getBytes());
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        System.out.println("client send:" + msg);
    }


}
