package com.demo.springcloud.remote;

import cn.hutool.json.JSONObject;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * es操作service
 *
 * @author liuxilin
 * @date 2022/3/13 21:43
 */
public interface ElasticsearchService {

    /**
     * 根据索引名称创建索引
     * @param indexname 索引名
     * @return
     */
    CreateIndexResponse createIndex(String indexname);

    /**
     * 根据索引定义创建索引
     * @param indexname 索引名称
     * @param source 索引定义
     * @return
     */
    CreateIndexResponse createIndex(String indexname, JSONObject source);

    /**
     * 更新索引mapping定义, 只能新增字段, 无法删除或修改字段
     * @param indexname 索引名称
     * @param source mapping定义
     * @return
     */
    AcknowledgedResponse updateIndexMapping(String indexname, JSONObject source);

    /**
     * 删除索引
     * @param indexname
     */
    void deleteIndex(String indexname);


}
