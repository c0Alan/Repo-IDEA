package com.demo.springcloud.config;

import com.demo.springcloud.entity.ElasticsearchPhone;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @author liuxl
 * @date 2024/10/27
 */
@Slf4j
@Configuration
public class ElasticsearchConfig {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Value("classpath:elasticsearch/phone_setting.json")
    private Resource esSetting;

    @PostConstruct
    public void init() throws Exception {
        String setting = IOUtils.toString(esSetting.getInputStream(), StandardCharsets.UTF_8);
        if (!elasticsearchRestTemplate.indexExists(ElasticsearchPhone.class)){
            boolean result = elasticsearchRestTemplate.createIndex(ElasticsearchPhone.class, setting);
            elasticsearchRestTemplate.putMapping(ElasticsearchPhone.class);
            log.info("es index inited：" + result);
        }

    }

}
