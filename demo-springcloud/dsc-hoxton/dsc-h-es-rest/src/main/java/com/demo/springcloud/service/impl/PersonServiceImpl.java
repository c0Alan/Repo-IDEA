package com.demo.springcloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import com.demo.springcloud.entity.Person;
import com.demo.springcloud.service.BaseElasticsearchService;
import com.demo.springcloud.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * PersonServiceImpl
 *
 * @author fxbin
 * @version v1.0
 * @since 2019-09-15 23:08
 */
@Slf4j
@Service
public class PersonServiceImpl extends BaseElasticsearchService implements PersonService {

    @Override
    public CreateIndexResponse createIndex(String index) {
        return createIndexRequest(index);
    }

    @Override
    public CreateIndexResponse createIndex(String index, JSONObject source) {
        CreateIndexRequest request = new CreateIndexRequest(index);
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
    public AcknowledgedResponse updateIndexMapping(String index, JSONObject mapping) {
        PutMappingRequest request = new PutMappingRequest(index);
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
    public void deleteIndex(String index) {
        deleteIndexRequest(index);
    }

    /**
     * 批量遍历插入数据
     *
     * @param index elasticsearch index name
     * @param list  data source
     * @return
     */
    @Override
    public List insertAll(String index, List<Person> list) {

        try {
            List result = new ArrayList();
            list.forEach(person -> {
                IndexRequest request = buildIndexRequest(index, String.valueOf(person.getId()), person);
                try {
                    IndexResponse indexResponse = client.index(request, COMMON_OPTIONS);
                    result.add(indexResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return result;
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List updateAll(String index, List<Person> list) {
        List result = new ArrayList();
        list.forEach(person -> {
            UpdateResponse updateResponse = updateRequest(index, String.valueOf(person.getId()), person);
            result.add(updateResponse);
        });
        return result;
    }

    @Override
    public List delete(String index, Person person) {
        List result = new ArrayList();
        if (ObjectUtils.isEmpty(person)) {
            // 如果person 对象为空，则删除全量
            searchList(index).forEach(p -> {
                DeleteResponse deleteResponse = deleteRequest(index, String.valueOf(p.getId()));
                result.add(deleteResponse);
            });
            return result;
        }
        DeleteResponse deleteResponse = deleteRequest(index, String.valueOf(person.getId()));
        result.add(deleteResponse);
        return result;
    }

    @Override
    public List<Person> searchList(String index) {
        SearchResponse searchResponse = search(index);
        List<Person> personList = getPeople(searchResponse);
        return personList;
    }

    @Override
    public List<Person> searchPersonByName() throws IOException {
        SearchResponse searchResponse = searchByName();
        List<Person> personList = getPeople(searchResponse);
        return personList;
    }

    private List<Person> getPeople(SearchResponse searchResponse) {
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Person> personList = new ArrayList<>();
        Arrays.stream(hits).forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            Person person = BeanUtil.toBean(sourceAsMap, Person.class);
            personList.add(person);
        });
        return personList;
    }
}
