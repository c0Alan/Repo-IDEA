package com.demo.springcloud.controller;

import com.demo.springcloud.remote.NacosServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RefreshScope
public class HelloController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    NacosServerService nacosServerService;

    @Value("${demo.name:}")
    private String name;

    @GetMapping("/callHello")
    public String callHello() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("dsc-f-nacos-server");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @GetMapping("/callHelloRestTemplate")
    public String callHelloRestTemplate() {
        String result = restTemplate.getForObject("http://dsc-f-nacos-server/hello?name=" + name, String.class);
        return "Return : " + result;
    }

    @GetMapping("/callHelloWebClient")
    public Mono<String> callHelloWebClient() {
        Mono<String> result = webClientBuilder.build()
                .get()
                .uri("http://dsc-f-nacos-server/hello?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
        return result;
    }

    @GetMapping("/callHelloFeignClient")
    public String callHelloFeignClient() {
        String result = nacosServerService.hello(name);
        return "Return : " + result;
    }
}
