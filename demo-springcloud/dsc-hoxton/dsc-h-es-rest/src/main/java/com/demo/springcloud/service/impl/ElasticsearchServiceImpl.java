package com.demo.springcloud.service.impl;

import cn.hutool.json.JSONObject;
import com.demo.springcloud.service.BaseElasticsearchService;
import com.demo.springcloud.service.ElasticsearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * @author liuxilin
 * @date 2022/3/26 9:06
 */
@Slf4j
@Service
public class ElasticsearchServiceImpl extends BaseElasticsearchService implements ElasticsearchService {

    @Override
    public CreateIndexResponse createIndex(String indexname) {
        return createIndexRequest(indexname);
    }

    @Override
    public CreateIndexResponse createIndex(String indexname, JSONObject source) {
        CreateIndexRequest request = new CreateIndexRequest(indexname);
        request.source(source);
        CreateIndexResponse response = null;
        try {
            response = client.indices().create(request, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error("创建索引失败: {}", e);
        }

        return response;
    }

    @Override
    public AcknowledgedResponse updateIndexMapping(String indexname, JSONObject mapping) {
        PutMappingRequest request = new PutMappingRequest(indexname);
        request.source(mapping);
        AcknowledgedResponse response = null;
        try {
            response = client.indices().putMapping(request, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error("更新索引失败: {}", e);
        }

        return response;
    }

    @Override
    public void deleteIndex(String indexname) {
        deleteIndexRequest(indexname);
    }

}
