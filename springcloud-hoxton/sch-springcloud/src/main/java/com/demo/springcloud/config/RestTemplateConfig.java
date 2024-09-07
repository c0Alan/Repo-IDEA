package com.demo.springcloud.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public HttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(500);
        // 设置每个路由的最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);
        return poolingHttpClientConnectionManager;
    }

    @Bean
    public HttpClient httpClient(HttpClientConnectionManager poolingHttpClientConnectionManager) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 设置 HttpClient 的连接管理器
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        return httpClientBuilder.build();
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        // 设置 HttpClient
        clientHttpRequestFactory.setHttpClient(httpClient);
        // 设置连接超时时间（毫秒）
        clientHttpRequestFactory.setConnectTimeout(5 * 1000);
        // 设置读取超时时间（毫秒）
        clientHttpRequestFactory.setReadTimeout(10 * 1000);
        // 设置从连接池获取连接的超时时间（毫秒）
        clientHttpRequestFactory.setConnectionRequestTimeout(10 * 1000);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate();
        // 设置请求工厂
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }

    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}
