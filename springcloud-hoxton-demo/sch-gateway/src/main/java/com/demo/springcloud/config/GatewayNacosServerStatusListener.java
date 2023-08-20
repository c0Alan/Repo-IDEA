package com.demo.springcloud.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 参考：https://blog.csdn.net/weixin_44606481/article/details/129926744
 * @author liuxilin
 * @date 2023/8/20 21:19
 */
@Slf4j
@Component
public class GatewayNacosServerStatusListener {

    /**
     * 该对象会在RibbonAutoConfiguration中被加载，可以通过这个工厂获取对应服务负载均衡器，从而刷新指定rebbon中的服务地址信息
     */
    @Autowired
    private SpringClientFactory springClientFactory;

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

    @PostConstruct
    public void init() {
        try {
            //获取 NamingService
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            //获取所有的服务名称 这里从gateway路由信息中获取
            List<RouteDefinition> routes = gatewayProperties.getRoutes();
            //订阅服务，服务状态刷新时，更新ribbon
            routes.stream().forEach(item -> {
                String service = item.getId();
                //订阅服务状态发生改变时，刷新 ribbon 服务实例
                try {
                    namingService.subscribe(service, (event -> {
                        ILoadBalancer loadBalancer = springClientFactory.getLoadBalancer(service);
                        if (loadBalancer != null) {
                            log.info("刷新 ribbon 服务实例：{}", service);
                            ((ZoneAwareLoadBalancer<?>) loadBalancer).updateListOfServers();
                            log.info("刷新 ribbon 服务实例成功：{}", service);
                        }
                    }));
                } catch (NacosException e) {
                    log.error("订阅 nacos 服务失败,error:{}", e.getErrMsg());
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            log.error("获取 nacos 服务信息失败,error:{}", e.getMessage());
            e.printStackTrace();
        }
    }
}
