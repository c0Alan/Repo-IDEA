package com.demo.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Server01Client01 {

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        // 创建EventLoopGroup，用于处理客户端的I/O操作
        EventLoopGroup groupThread = new NioEventLoopGroup();

        try {
            // 创建Bootstrap实例，客户端启动对象
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(groupThread);
            // 设置服务端Channel类型为NioSocketChannel作为通道实现
            bootstrap.channel(NioSocketChannel.class);
            // 设置客户端处理
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new Server01Client01Handler());
                }
            });
            // 绑定端口
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8888).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 优雅地关闭线程
            groupThread.shutdownGracefully();
        }
    }
}
