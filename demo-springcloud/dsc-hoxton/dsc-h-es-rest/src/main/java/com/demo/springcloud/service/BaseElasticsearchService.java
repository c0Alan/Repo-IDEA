package com.demo.springcloud.service;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ElasticsearchService 基类
 *
 * @author liuxilin
 * @date 2022/3/14 12:42
 */
@Slf4j
public abstract class BaseElasticsearchService {

    @Resource
    protected RestHighLevelClient client;

    protected static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();

        // 默认缓冲限制为100MB，此处修改为30MB。
        builder.setHttpAsyncResponseConsumerFactory(
                new HttpAsyncResponseConsumerFactory.
                        HeapBufferedResponseConsumerFactory(30 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

    /**
     * 根据索引名称创建索引
     *
     * @param index 索引名称
     */
    protected CreateIndexResponse createIndexRequest(String index) {
        try {
            CreateIndexRequest request = new CreateIndexRequest(index);
            // 1个分片, 0个副本
            request.settings(Settings.builder().
                    put("index.number_of_shards", 1).
                    put("index.number_of_replicas", 0));

            CreateIndexResponse createIndexResponse = client.indices().create(request, COMMON_OPTIONS);

            log.info("createIndexResponse.isAcknowledged: {}", createIndexResponse.isAcknowledged());
            log.info("createIndexResponse.isShardsAcknowledged:{}", createIndexResponse.isShardsAcknowledged());
            return createIndexResponse;
        } catch (IOException e) {
            throw new ElasticsearchException("创建索引 {" + index + "} 失败");
        }
    }

    /**
     * 删除索引
     *
     * @param index 索引名称
     */
    protected void deleteIndexRequest(String index) {
        DeleteIndexRequest deleteIndexRequest = buildDeleteIndexRequest(index);
        try {
            client.indices().delete(deleteIndexRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            throw new ElasticsearchException("删除索引 {" + index + "} 失败");
        }
    }

    /**
     * @param index 索引名称
     * @return
     */
    private static DeleteIndexRequest buildDeleteIndexRequest(String index) {
        return new DeleteIndexRequest(index);
    }

    /**
     * 新增单条数据
     *
     * @param index  索引名称
     * @param id     数据id
     * @param object 数据对象
     * @return
     */
    protected static IndexRequest buildIndexRequest(String index, String id, Object object) {
        return new IndexRequest(index).id(id).source(BeanUtil.beanToMap(object), XContentType.JSON);
    }

    /**
     * 更新单条数据
     *
     * @param index  索引名称
     * @param id     数据id
     * @param object
     */
    protected UpdateResponse updateRequest(String index, String id, Object object) {
        try {
            UpdateRequest updateRequest = new UpdateRequest(index, id).doc(BeanUtil.beanToMap(object), XContentType.JSON);
            UpdateResponse updateResponse = client.update(updateRequest, COMMON_OPTIONS);
            return updateResponse;
        } catch (IOException e) {
            throw new ElasticsearchException("更新索引 {" + index + "} 数据 {" + object + "} 失败");
        }
    }

    /**
     * 删除单条数据
     *
     * @param index 索引名称
     * @param id    数据id
     * @return
     */
    protected DeleteResponse deleteRequest(String index, String id) {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(index, id);
            DeleteResponse deleteResponse = client.delete(deleteRequest, COMMON_OPTIONS);
            return deleteResponse;
        } catch (IOException e) {
            throw new ElasticsearchException("删除索引 {" + index + "} 数据id {" + id + "} 失败");
        }
    }

    /**
     * 根据索引名称查询全部数据
     *
     * @param index 索引名称
     * @return
     */
    protected SearchResponse search(String index) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResponse;
    }

    protected RestStatus bulkInsert(String indexname, List<Map> datas) {
        BulkRequest bulkRequest = new BulkRequest();
        datas.forEach(data -> {
            // id 设null, 采用es自动生成id
            IndexRequest indexRequest = new IndexRequest(indexname).id(null).source(data, XContentType.JSON);
            bulkRequest.add(indexRequest);
        });
        BulkResponse bulkResponse = null;
        try {
            bulkResponse = client.bulk(bulkRequest, COMMON_OPTIONS);
            if(bulkResponse.hasFailures()){
                log.error("新增数据错误: {}", bulkResponse.buildFailureMessage());
            }
        } catch (IOException e) {
            log.error("批量新增失败: {}", e);
            log.error("请求: {}", bulkRequest);
            return RestStatus.EXPECTATION_FAILED;
        }
        return bulkResponse.status();
    }

}
