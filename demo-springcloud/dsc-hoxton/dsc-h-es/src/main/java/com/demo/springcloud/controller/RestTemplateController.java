package com.demo.springcloud.controller;

import com.demo.springcloud.entity.DocBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author liuxilin
 * @date 2022年03月11日 12:44
 */
@Slf4j
@RequestMapping("/restTemplate")
@RestController
public class RestTemplateController {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;


    @GetMapping("/createIndex")
    public boolean createIndex() {
        boolean result = elasticsearchTemplate.createIndex(DocBean.class);
        log.info("{}", result);

        return result;
    }



}
