package com.demo.springcloud.repository;

import com.demo.springcloud.entity.ElasticsearchDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ElasticRepository extends ElasticsearchRepository<ElasticsearchDoc, Long> {

    //默认的注释
    @Query("{\"match\":{\"content\":\"xxxxxx\"}}")
    Page<ElasticsearchDoc> findByContent(String content, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
    Page<ElasticsearchDoc> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}")
    Page<ElasticsearchDoc> findBySecordCode(String secordCode, Pageable pageable);


}