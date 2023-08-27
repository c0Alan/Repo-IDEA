package com.demo.springcloud.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Configuration;

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

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/sch-scheduler/hello")
                        .uri("http://192.168.80.128:30008/hello?name=ddd"))
                .build();
    }*/

    /*@Bean
    public RouteLocator nacosServiceRoutes(RouteLocatorBuilder locatorBuilder) throws NacosException {
        List<String> services = nacosServiceDiscovery.getServices();

        RouteLocatorBuilder.Builder builder = null;
        for (String service : services) {
            if (builder == null) {
                builder = locatorBuilder.routes().route(service, p -> p.path("/" + service + "/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://" + service));
                continue;
            }
            builder.route(service, p -> p.path("/" + service + "/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("lb://" + service));

        }

        return builder.build();
    }*/

}
