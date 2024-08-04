package com.demo.java.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * 服务端、客户端双向读写
 *
 * @author liuxl
 * @date 2024/5/4
 */
@Slf4j
public class Server06 {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓冲区大小为1024字节
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

    private List<SocketChannel> clients = new ArrayList<>();


    /**
     * 通过控制台写入消息
     */
    public static void main(String[] args) throws Exception {
        Server06 server06 = new Server06(8000);

        new Thread(() -> {
            try {
                server06.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            server06.sendToClient(next);
        }

    }

    public Server06(int port) throws IOException {
        // 打开服务器套接字通道
        this.serverSocketChannel = ServerSocketChannel.open();
        // 服务器配置为非阻塞 即异步IO
        this.serverSocketChannel.configureBlocking(false);
        // 绑定本地端口
        this.serverSocketChannel.bind(new InetSocketAddress(port));
        // 创建选择器
        this.selector = Selector.open();
        // 注册接收连接事件
        this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 启动服务
     */
    public void start() throws IOException {
        log.info("Server06 start");
        while (true) {
            int select = selector.select();
            if (select > 0) {
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        // 接受客户端连接
                        SocketChannel client = serverSocketChannel.accept();
                        log.info("Server06 accept client " + client.getRemoteAddress());
                        // 配置为非阻塞
                        client.configureBlocking(false);
                        // 注册连接事件
                        client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        clients.add(client);
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        try {
                            readBuffer.clear();
                            int read = client.read(readBuffer);
                            if (read > 0) {
                                readBuffer.flip();
                                byte[] bytes = new byte[readBuffer.limit()];
                                readBuffer.get(bytes);
                                log.info("Server06 receive msg from client:{}, msg:{}", client.getRemoteAddress(), new String(bytes));
                            }
                        } catch (IOException e) {
                            log.error("Server06 read error", e);
                        }
                    }
                }
            }
        }
    }

    /**
     * 发送消息
     */
    public void sendToClient(String msg) {
        for (SocketChannel client : clients) {
            try {
                sendBuffer.clear();
                sendBuffer.put(msg.getBytes());
                sendBuffer.flip();
                client.write(sendBuffer);
                log.info("Server06 send msg to client:{}, msg:{}", client.getRemoteAddress(), msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
