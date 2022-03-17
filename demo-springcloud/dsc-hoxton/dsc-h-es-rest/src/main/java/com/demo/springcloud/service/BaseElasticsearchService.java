package com.demo.springcloud.service;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
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
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
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
     * 创建索引
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
     * build DeleteIndexRequest
     *
     * @param index elasticsearch index name
     * @author fxbin
     */
    private static DeleteIndexRequest buildDeleteIndexRequest(String index) {
        return new DeleteIndexRequest(index);
    }

    /**
     * 插入数据
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
     * 更新数据
     *
     * @param index
     * @param id
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
     * 删除数据
     *
     * @param index 索引名称
     * @param id
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
     * 查询全部数据
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

    public SearchResponse searchByName() throws IOException {
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //这里可以根据字段进行搜索，must表示符合条件的，相反的mustnot表示不符合条件的
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "王安石");
        //新建range条件
        // RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("fields_timestamp");
        //开始时间
        // rangeQueryBuilder.gte("2019-03-21T08:24:37.873Z");
        //结束时间
        // rangeQueryBuilder.lte("2019-03-21T08:24:37.873Z");
        // boolBuilder.must(rangeQueryBuilder);
        boolBuilder.must(matchQueryBuilder);
        //设置查询，可以是任何类型的QueryBuilder。
        sourceBuilder.query(boolBuilder);
        //设置确定结果要从哪个索引开始搜索的from选项，默认为0
        sourceBuilder.from(0);
        //设置确定搜素命中返回数的size选项，默认为10
        sourceBuilder.size(100);
        //设置一个可选的超时，控制允许搜索的时间。
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //第一个是获取字段，第二个是过滤的字段，默认获取全部
        // sourceBuilder.fetchSource(new String[]{"id", "name", "age"}, new String[]{});
        //索引
        SearchRequest searchRequest = new SearchRequest("idx_dsc_person");
        searchRequest.source(sourceBuilder);
        log.info("{}",searchRequest.source());
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return response;
    }
}
