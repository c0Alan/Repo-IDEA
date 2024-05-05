package com.demo.java.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server01 {

    /**
     * 接收客户端消息，并返回
     * chcp 65001
     * nc localhost 8888
     * @param args
     */
    public static void main(String[] args) {
        try {
            bind();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bind() throws InterruptedException {

        // 创建boss线程组，用于接收连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 创建worker线程组，用于处理连接上的I/O操作，含有子线程NioEventGroup个数为CPU核数大小的2倍
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建ServerBootstrap实例，服务器启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 使用链式编程配置参数
            // 将boss线程组和worker线程组暂存到ServerBootstrap
            bootstrap.group(bossGroup, workerGroup);
            // 设置服务端Channel类型为NioServerSocketChannel作为通道实现
            bootstrap.channel(NioServerSocketChannel.class);

            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    // 添加ServerHandler到ChannelPipeline，对workerGroup的SocketChannel（客户端）设置处理器
                    pipeline.addLast(new Server01Handler());
                }
            });
            // 设置启动参数，初始化服务器连接队列大小。服务端处理客户端连接请求是顺序处理，一个时间内只能处理一个客户端请求
            // 当有多个客户端同时来请求时，未处理的请求先放入队列中
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            // 绑定端口并启动服务器，bind方法是异步的，sync方法是等待异步操作执行完成，返回ChannelFuture异步对象
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();
            // 等待服务器关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 优雅地关闭boss线程组
            bossGroup.shutdownGracefully();
            // 优雅地关闭worker线程组
            workerGroup.shutdownGracefully();
        }
    }
}
