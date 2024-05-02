package com.demo.java.nio;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.channels.*;

/**
 * nio 中 channel 示例
 *
 * @author liuxl
 * @date 2024/5/1
 */
public class ChannelDemo {

    public static void main(String[] args) throws IOException {

    }

    /**
     * 列出了不同类型网络通道支持的所有Socket选项。
     */
    @Test
    public void test01() throws IOException {
        printOptions(SocketChannel.open());
        printOptions(ServerSocketChannel.open());
        printOptions(AsynchronousSocketChannel.open());
        printOptions(AsynchronousServerSocketChannel.open());
        printOptions(DatagramChannel.open());
    }


    private static void printOptions(NetworkChannel channel) throws IOException {
        System.out.println(channel.getClass().getSimpleName() + " supports:");
        for (SocketOption<?> option : channel.supportedOptions()) {
            System.out.println(option.name() + ": " + channel.getOption(option));
        }
        System.out.println();
        channel.close();
    }

}
