package com.demo.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Server05Client01 {
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private SocketChannel sc;
    private Selector selector;


    public static void main(String[] args) throws Exception {
        new Server05Client01("localhost", 8000).send();
    }

    public Server05Client01(String hostname, int port) throws IOException {
        // 打开socket通道
        sc = SocketChannel.open();
        // 配置为非阻塞 即异步IO
        sc.configureBlocking(false);
        // 连接服务器端
        sc.connect(new InetSocketAddress(hostname, port));
        // 创建选择器
        selector = Selector.open();
        // 注册请求连接事件
        sc.register(selector, SelectionKey.OP_CONNECT);
    }

    public void send() throws IOException {
        Scanner scanner = new Scanner(System.in);
        // 无限判断当前线程状态，如果没有中断，就一直执行while内容。
        while (!Thread.currentThread().isInterrupted()) {
            // 获取准备就绪的channel
            if (selector.select() == 0) {
                continue;
            }

            // 获取到对应的 SelectionKey 对象
            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println("all keys is:" + keys.size());
            Iterator<SelectionKey> iterator = keys.iterator();
            // 遍历所有的 SelectionKey 对象
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //判断此通道上是否在进行连接操作
                if (key.isConnectable()) {
                    sc.finishConnect();
                    //注册写操作
                    sc.register(selector, SelectionKey.OP_WRITE);
                    System.out.println("server connected...");
                    break;
                } else if (key.isWritable()) {
                    System.out.println("please input message:");
                    String message = scanner.nextLine();
                    writeBuffer.clear();
                    writeBuffer.put(message.getBytes());
                    //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
                    writeBuffer.flip();
                    sc.write(writeBuffer);
                    key.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    sc.read(readBuffer);
                    readBuffer.flip();
                    while (readBuffer.hasRemaining()) {
                        System.out.print((char) readBuffer.get());
                    }
                    System.out.println();
                    readBuffer.clear();
                    key.interestOps(SelectionKey.OP_WRITE);
                }
                // 移除当前的key
                iterator.remove();
            }
        }
    }


}
