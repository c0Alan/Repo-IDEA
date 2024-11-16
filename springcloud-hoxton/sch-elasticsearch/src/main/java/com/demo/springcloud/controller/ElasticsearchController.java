package com.demo.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.demo.springcloud.entity.ElasticsearchPhone;
import com.demo.springcloud.repository.ElasticsearchPhoneRepository;
import com.demo.springcloud.response.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * elasticsearch 操作
 * 参考：https://blog.csdn.net/jdbcmeng/article/details/125496006
 *
 * @author liuxl
 * @date 2024/10/28
 */
@Slf4j
@Api(tags = "elasticsearch操作")
@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {
    @Autowired
    private ElasticsearchPhoneRepository phoneRepository;

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 插入数据
     */
    @PostMapping("/save")
    public void save(@RequestBody ElasticsearchPhone phone) {
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(phone).build();
        elasticsearchRestTemplate.index(indexQuery);
    }


    //批量插入数据
    @GetMapping("/batchSave")
    public void batchSave() {
        ElasticsearchPhone phone2 = new ElasticsearchPhone(5, "小米", "小米5pro", "备注");
        ElasticsearchPhone phone3 = new ElasticsearchPhone(6, "苹果", "iphone6", "备注");
        IndexQueryBuilder indexQueryBuilder = new IndexQueryBuilder();
        List<IndexQuery> indexQueryList = new ArrayList<>();
        indexQueryList.add(indexQueryBuilder.withObject(phone2).build());
        indexQueryList.add(indexQueryBuilder.withObject(phone3).build());
        elasticsearchRestTemplate.bulkIndex(indexQueryList);
    }

    //批量插入数据
    @GetMapping("/batchSave2")
    public void batchSave2() {
        List<ElasticsearchPhone> list = new ArrayList<>();
        ElasticsearchPhone phone2 = new ElasticsearchPhone(2, "小米", "小米2pro", "备注");
        ElasticsearchPhone phone3 = new ElasticsearchPhone(3, "苹果", "iphone3", "备注");
        list.add(phone2);
        list.add(phone3);
        phoneRepository.saveAll(list);
    }

    //修改数据
    @PostMapping("/update")
    public void update(@RequestBody ElasticsearchPhone phone) {
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(phone).build();
        elasticsearchRestTemplate.index(indexQuery);
    }

    //删除数据
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        elasticsearchRestTemplate.delete(ElasticsearchPhone.class, id);
    }

    /**
     * 删除id为id的数据
     */
    @GetMapping("/delete2/{id}")
    public void delete2(@PathVariable long id) {
        phoneRepository.deleteById(id);
    }

    /**
     * 删除id大于gtId的数据
     */
    @GetMapping("/deleteByCriteriaQuery")
    public void deleteByCriteriaQuery(@RequestParam int gtId) {
        Criteria criteria = Criteria.where("id").greaterThan(gtId);
        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
        elasticsearchRestTemplate.delete(criteriaQuery, ElasticsearchPhone.class);
    }

    @GetMapping("/updateMapping")
    public void updateMapping() {
        elasticsearchRestTemplate.putMapping(ElasticsearchPhone.class);
    }


    //查询全部
    @GetMapping("/getAll")
    public ResponseResult getAll() {
        Iterable<ElasticsearchPhone> phones = phoneRepository.findAll();
        return ResponseResult.success(phones);
    }

    //根据id查询
    @GetMapping("/getById/{id}")
    public ResponseResult getById(@PathVariable long id) {
        Optional<ElasticsearchPhone> phone = phoneRepository.findById(id);
        return ResponseResult.success(phone);
    }

    //根据ids查询
    @GetMapping("/getByIds")
    public ResponseResult getByIds(String ids) {
        Iterable<ElasticsearchPhone> phones = phoneRepository.findAllById(Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList()));
        return ResponseResult.success(phones);
    }

    //repository自定义方法查询
    @PostMapping("/search")
    public ResponseResult search(@RequestBody ElasticsearchPhone phone) {
        PageRequest pageRequest = PageRequest.of(0, 10);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        if (StrUtil.isNotBlank(phone.getBrand())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.fuzzyQuery("brand", phone.getBrand()));
        }
        if (StrUtil.isNotBlank(phone.getName())) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.fuzzyQuery("name", phone.getName()));
        }
        Page<ElasticsearchPhone> page = phoneRepository.search(nativeSearchQueryBuilder.build().getQuery(), pageRequest);

        return ResponseResult.success(page);
    }

    @PostMapping("/queryForPage")
    public ResponseResult queryForPage(@RequestBody ElasticsearchPhone phone) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (StrUtil.isNotBlank(phone.getBrand())){
            boolQueryBuilder.must(QueryBuilders.fuzzyQuery("brand", phone.getBrand()));
        }
        if (StrUtil.isNotBlank(phone.getName())){
            boolQueryBuilder.must(QueryBuilders.fuzzyQuery("name", phone.getName()));
        }
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(PageRequest.of(0, 10))
                .build();
        log.info("DSL：{}", query.getQuery().toString());
        Page<ElasticsearchPhone> page = elasticsearchRestTemplate.queryForPage(query, ElasticsearchPhone.class);
        return ResponseResult.success(page);
    }

}
