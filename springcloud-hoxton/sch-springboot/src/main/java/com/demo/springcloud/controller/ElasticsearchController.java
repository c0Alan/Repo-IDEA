package com.demo.springcloud.controller;

import com.demo.springcloud.entity.ElasticsearchPhone;
import com.demo.springcloud.repository.ElasticsearchPhoneRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * elasticsearch 操作
 * 参考：https://blog.csdn.net/jdbcmeng/article/details/125496006
 *
 * @author liuxl
 * @date 2024/10/28
 */
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
        List<ElasticsearchPhone> list = new ArrayList<>();
        ElasticsearchPhone phone2 = new ElasticsearchPhone(5, "小米", "小米5pro");
        ElasticsearchPhone phone3 = new ElasticsearchPhone(6, "苹果", "iphone6");
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
        ElasticsearchPhone phone2 = new ElasticsearchPhone(2, "小米", "小米2pro");
        ElasticsearchPhone phone3 = new ElasticsearchPhone(3, "苹果", "iphone3");
        list.add(phone2);
        list.add(phone3);
        phoneRepository.saveAll(list);
    }

    //修改数据
    @PostMapping("/update")
    public void update(@RequestBody ElasticsearchPhone phone){
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(phone).build();
        elasticsearchRestTemplate.index(indexQuery);
    }

    //删除数据
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        elasticsearchRestTemplate.delete(ElasticsearchPhone.class, id);
    }

    /**
     * 删除id为id的数据
     */
    @GetMapping("/delete2/{id}")
    public void delete2(@PathVariable long id){
        phoneRepository.deleteById(id);
    }

    /**
     * 删除id大于gtId的数据
     */
    @GetMapping("/deleteByCriteriaQuery")
    public void deleteByCriteriaQuery(@RequestParam int gtId){
        Criteria criteria = Criteria.where("id").greaterThan(gtId);
        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
        elasticsearchRestTemplate.delete(criteriaQuery, ElasticsearchPhone.class);
    }


}
