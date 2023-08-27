package com.demo.springcloud.listener;

import cn.hutool.json.JSONUtil;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.client.config.impl.ServerlistChangeEvent;
import com.alibaba.nacos.common.notify.NotifyCenter;
import com.alibaba.nacos.common.notify.listener.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.CachingRouteLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.RouteRefreshListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 路由列表刷新监听器
 * 参考：https://blog.csdn.net/weixin_42321034/article/details/119347847
 *
 * @author liuxilin
 * @date 2023/8/27 22:49
 */
@Slf4j
@Component
public class ServerListChangeEventListener extends Subscriber<ServerlistChangeEvent> implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private RouteRefreshListener routeRefreshListener;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RouteLocator routeLocator;

    @PostConstruct
    private void post() {
        NotifyCenter.registerSubscriber(this);
    }


    /**
     * Event callback.
     *
     * @param event {@link Event}
     */
    @Override
    public void onEvent(ServerlistChangeEvent event) {
        log.info("接收到 ServerListChangeEvent 订阅事件：{}", JSONUtil.toJsonStr(event));
        publishEvent();
    }

    /**
     * Type of this subscriber's subscription.
     *
     * @return Class which extends {@link Event}
     */
    @Override
    public Class<? extends com.alibaba.nacos.common.notify.Event> subscribeType() {
        return ServerlistChangeEvent.class;
    }

    public void publishEvent() {
        CachingRouteLocator cachingRouteLocator = (CachingRouteLocator) routeLocator;
        cachingRouteLocator.refresh();
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(new Object()));
        routeRefreshListener.onApplicationEvent(new ContextRefreshedEvent(applicationContext));
        cachingRouteLocator.onApplicationEvent(new RefreshRoutesEvent(new Object()));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

