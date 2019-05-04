package com.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 广播式 对应 ws.html
 * 广播式即服务端有消息时，会将消息发送给所有连接了当前endpoint 的浏览器。
 * 通过@EnableWebSocketMessageBroker 注解开启使用STOMP 协议来传输基于代理( message broker )的消息，
 * 这时控制器支持使用@MessageMapping ，就像使用@RequestMapping一样。
 *
 * @author liuxilin
 * @date 2018/6/12 21:51
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册STOMP 协议的节点( endpoint )，并映射的指定的URL
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP 的endpoint ，并指定使用SockJS 协议.
        registry.addEndpoint("/endpointWisely").withSockJS();
        // 注册一个名为/endpointChat 的endpoint
        registry.addEndpoint("/endpointChat").withSockJS();
    }


    /**
     * 配置消息代理( Messagc Broker )。
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 广播式应配置一个/topic 消息代理。
        // 点对点式应增加一个/queue 消息代理。
        registry.enableSimpleBroker("/queue", "/topic");
    }

}
