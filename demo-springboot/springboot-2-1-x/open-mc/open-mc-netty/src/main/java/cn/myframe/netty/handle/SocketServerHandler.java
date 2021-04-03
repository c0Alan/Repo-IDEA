package cn.myframe.netty.handle;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ynz
 * @version 创建时间：2018/6/26
 * @email ynz@myframe.cn
 */
@Component
@Slf4j
@ChannelHandler.Sharable //@Sharable 注解用来说明ChannelHandler是否可以在多个channel直接共享使用
public class SocketServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
	//	System.out.println(msg);
		ctx.writeAndFlush("text");
		ctx.channel().close();
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		String resourceName = "testSentinel";
		Entry entry = null;
		String retVal;
		try{
			entry = SphU.entry(resourceName,EntryType.IN);
			retVal = "passed";
		}catch(BlockException e){
			retVal = "blocked";
		}finally {
			if(entry!=null){
				entry.exit();
			}
		}

		log.info("连接");
	}

}
