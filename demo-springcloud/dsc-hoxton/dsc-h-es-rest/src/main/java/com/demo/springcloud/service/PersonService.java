package com.demo.springcloud.service;

import cn.hutool.core.bean.BeanUtil;
import com.demo.springcloud.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * person 服务类
 *
 * @author liuxilin
 * @date 2022年03月26日 9:01
 */
@Slf4j
@Service
public class PersonService extends BaseElasticsearchService {
    @Autowired
    ToolBasedataService toolBasedataService;

    private String personIndexname = "idx_dsc_person";

    /**
     * 新增随机数据
     * @param size 数据量
     * @return
     */
    public RestStatus addRandom(@RequestParam int size){
        Map data = toolBasedataService.getRandomDataList("person.json", size);
        List<Map> datas = (List<Map>) data.get("data");
        RestStatus status = bulkInsert(personIndexname, datas);

        return status;
    }

    /**
     * 批量遍历插入数据
     *
     * @param index elasticsearch index name
     * @param list  data source
     * @return
     */
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

    public List updateAll(String index, List<Person> list) {
        List result = new ArrayList();
        list.forEach(person -> {
            UpdateResponse updateResponse = updateRequest(index, String.valueOf(person.getId()), person);
            result.add(updateResponse);
        });
        return result;
    }

    public List<Person> searchList(String index) {
        SearchResponse searchResponse = search(index);
        List<Person> personList = getPeople(searchResponse);
        return personList;
    }

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

    public List<Person> searchPersonByName() throws IOException {
        SearchResponse searchResponse = searchByName();
        List<Person> personList = getPeople(searchResponse);
        return personList;
    }

    /**
     * 根据name字段查询数据
     * @return
     * @throws IOException
     */
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
