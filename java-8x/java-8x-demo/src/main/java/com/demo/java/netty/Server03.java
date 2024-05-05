package com.demo.java.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 *
 *
 * @author liuxl
 * @date 2024/5/5
 */
public class Server03 {

    /**
     * 向连接的客户端发送消息 "Hi!"
     * nc localhost 8888
     */
    public static void main(String[] args) {
        try {
            new Server03().server(8888);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void server(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                                      @Override
                                      public void initChannel(SocketChannel ch) throws Exception {
                                          ch.pipeline().addLast(
                                                  new ChannelInboundHandlerAdapter() {
                                                      @Override
                                                      public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                                          ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                                      }
                                                  });
                                      }
                                  }
                    );
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

}

