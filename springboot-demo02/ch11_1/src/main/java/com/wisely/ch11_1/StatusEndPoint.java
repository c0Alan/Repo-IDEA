package com.springboot.ch11_1;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 通过@ConfigurationProperties 的设置，我们可以在applicati on. properti es 中通过endpoints.status 配置我们的端点。
 *
 * 继承AbstractEndpoint 类， AbstractEndpoint 是Endpoint 接口的抽象实现，当前类一定要重写invoke 方法。
 * 实现ApplicationContextAware 接口可以让当前类对Spring 容器的资源有意识，即可访问容器的资源。
 */
@ConfigurationProperties(prefix = "endpoints.status", ignoreUnknownFields = false) //1
public class StatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware {//2

    ApplicationContext context;

    public StatusEndPoint() {
        super("status");
    }

    /**
     * 通过重写invoke 方法，返回我们要监控的内容。
     * @return
     */
    @Override
    public String invoke() { //3
        StatusService statusService = context.getBean(StatusService.class);
        return "The Current Status  is :" + statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.context = arg0;
    }
}
