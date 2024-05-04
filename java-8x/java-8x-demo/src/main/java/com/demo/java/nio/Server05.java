package com.demo.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 参考：https://blog.csdn.net/qq_33807380/article/details/134190775
 *
 * @author liuxl
 * @date 2024/5/4
 */
public class Server05 {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓冲区大小为1024字节
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    String str;


    public static void main(String[] args) throws Exception {
        System.out.println("sever start...");
        new Server05(8000).handle();
    }

    public Server05(int port) throws IOException {
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

    public void handle() throws IOException {
        // 无限判断当前线程状态，如果没有中断，就一直执行while内容。
        while (!Thread.currentThread().isInterrupted()) {
            // 获取准备就绪的channel
            if (selector.select() == 0) {
                continue;
            }

            // 获取到对应的 SelectionKey 对象
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            // 遍历所有的 SelectionKey 对象
            while (keyIterator.hasNext()) {
                // 根据不同的SelectionKey事件类型进行相应的处理
                SelectionKey key = keyIterator.next();
                if (!key.isValid()) {
                    continue;
                }
                if (key.isAcceptable()) {
                    accept(key);
                }
                if (key.isReadable()) {
                    read(key);
                }
                if (key.isWritable()) {
                    write(key);
                }
                // 移除当前的key
                keyIterator.remove();
            }
        }
    }

    /**
     * 客服端连接事件处理
     *
     * @param key
     * @throws IOException
     */
    private void accept(SelectionKey key) throws IOException {
        System.out.println("accept...");
        SocketChannel socketChannel = this.serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        // 注册客户端读取事件到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("client connected " + socketChannel.getRemoteAddress());
    }

    /**
     * 读取事件处理
     *
     * @param key
     * @throws IOException
     */
    private void read(SelectionKey key) throws IOException {
        System.out.println("read...");
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //清除缓冲区，准备接受新数据
        this.readBuffer.clear();
        int numRead;
        try {
            // 从 channel 中读取数据
            numRead = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            System.out.println("read failed");
            key.cancel();
            socketChannel.close();
            return;
        }
        str = new String(readBuffer.array(), 0, numRead);
        System.out.println("read String is: " + str);
        key.interestOps(SelectionKey.OP_WRITE);
    }


    public void write(SelectionKey key) throws IOException {
        System.out.println("Handling write");
        sendBuffer.put("hello world!".getBytes("UTF-8"));
        sendBuffer.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (sendBuffer.hasRemaining()) {
            sc.write(sendBuffer);
        }
        sendBuffer.compact();
        System.out.println("read String is: " + "hello world!");
        key.interestOps(SelectionKey.OP_READ);
    }


}
