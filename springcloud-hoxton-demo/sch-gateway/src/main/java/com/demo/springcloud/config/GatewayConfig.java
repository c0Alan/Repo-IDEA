package com.demo.springcloud.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GatewayConfig {

    /**
     * Gateway的路由信息配置会被提前加载好我们直接注入即可，一般我们会把路由id设置成各个服务名称，这里需要服务名称直接读取路由id
     */
    @Autowired
    private GatewayProperties gatewayProperties;

    /**
     * Nacos注册中心配置信息 包括我们需要的NamingService也能在里面获取到
     */
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Autowired
    NacosServiceManager nacosServiceManager;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    @Bean
    public RouteLocator nacosServiceRoutes(RouteLocatorBuilder builder) throws NacosException {
        List<String> services = nacosServiceDiscovery.getServices();


        return builder.routes().build();
    }

}
