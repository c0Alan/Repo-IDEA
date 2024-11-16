package com.demo.springcloud.repository;

import com.demo.springcloud.entity.ElasticsearchPhone;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author liuxl
 * @date 2024/10/28
 */
@Component
public interface ElasticsearchPhoneRepository extends ElasticsearchRepository<ElasticsearchPhone, Long> {

}