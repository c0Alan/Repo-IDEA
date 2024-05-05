package com.demo.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class Server01Handler extends ChannelInboundHandlerAdapter {

    /**
     * 当 Channel 已经注册到它的 EventLoop 并且能够处理 I/O 时被调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelRegistered");
    }

    /**
     * 当 Channel 从它的 EventLoop 注销并且无法处理任何 I/O 时被调
     * 用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelUnregistered");
    }

    /**
     * 当 Channel 处于活动状态时被调用；Channel 已经连接/绑定并且已经就绪
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelActive");
    }

    /**
     * 当 Channel 离开活动状态并且不再连接它的远程节点时被调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelInactive");
    }

    /**
     * 当从 Channel 读取数据时被调用
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("执行 channelRead");
        // 处理接收到的数据
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            // 将接收到的字节数据转换为字符串
            String message = byteBuf.toString(CharsetUtil.UTF_8);
            // 打印接收到的消息
            System.out.println("Server端收到客户消息: " + message);
            // 发送响应消息给客户端
            ctx.writeAndFlush(Unpooled.copiedBuffer("我是服务端，我收到你的消息啦~", CharsetUtil.UTF_8));
        } finally {
            // 释放ByteBuf资源
            ReferenceCountUtil.release(byteBuf);
        }

    }

    /**
     * 当 Channel 上的一个读操作完成时被调用，对通道的读取完成的事件或通知。当读取完成可通知发送方或其他的相关方，告诉他们接受方读取完成
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelReadComplete");
    }

    /**
     * 当 ChannelnboundHandler.fireUserEventTriggered()方法被调用时被
     * 调用
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("执行 userEventTriggered");
    }

    /**
     * 当 Channel 的可写状态发生改变时被调用。可以通过调用 Channel 的 isWritable()方法
     * * 来检测 Channel 的可写性。与可写性相关的阈值可以通过
     * * Channel.config().setWriteHighWaterMark()和 Channel.config().setWriteLowWaterMark()方法来
     * * 设置
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("执行 channelWritabilityChanged");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("执行 exceptionCaught");
        // 异常处理
        cause.printStackTrace();
        ctx.close();
    }
}
