package com.demo.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.demo.springcloud.remote.ElasticsearchService;
import com.demo.springcloud.remote.ToolFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参考: https://gitee.com/xkcoding/spring-boot-demo/tree/master/demo-elasticsearch-rest-high-level-client
 * @author liuxilin
 * @date 2022年03月11日 12:37
 */
@Slf4j
@RequestMapping("/restHighLevel")
@RestController
public class RestHighLevelController {
    @Autowired
    ElasticsearchService elasticsearchService;

    @Autowired
    ToolFileService toolFileService;

    @GetMapping("/createIndexByJson")
    public Object createIndexByJson(@RequestParam String indexName) {
        JSONObject source = toolFileService.getJsonFile(indexName + ".json");
        Object result = elasticsearchService.createIndex(indexName, source);
        return result;
    }

    @GetMapping("/createIndex")
    public Object createIndex() {
        Object result = elasticsearchService.createIndex("idx_dsc_person");

        return result;
    }

    /**
     * 更新索引mapping, es7只能加字段, 不能修改类型跟删字段
     * @param indexName
     * @return
     */
    @GetMapping("/updateIndexByJson")
    public Object updateIndexByJson(@RequestParam String indexName) {
        JSONObject source = toolFileService.getJsonFile(indexName + ".json");
        Object result = elasticsearchService.updateIndexMapping(indexName, source.getJSONObject("mappings"));
        return result;
    }

}
