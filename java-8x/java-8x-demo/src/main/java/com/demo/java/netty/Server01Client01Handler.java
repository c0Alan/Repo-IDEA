package com.demo.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class Server01Client01Handler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 连接建立时的处理，发送请求消息给服务器
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好，服务端！我是客户端，测试通道连接", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 处理接收到的数据
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            // 将接收到的字节数据转换为字符串
            String message = byteBuf.toString(CharsetUtil.UTF_8);
            // 打印接收到的消息
            System.out.println("收到服务端响应的消息: " + message);

            // TODO: 对数据进行业务处理

        } finally {
            // 释放ByteBuf资源
            ReferenceCountUtil.release(byteBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 异常处理
        cause.printStackTrace();
        ctx.close();
    }
}
