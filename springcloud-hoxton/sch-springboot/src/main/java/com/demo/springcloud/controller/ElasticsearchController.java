package com.demo.springcloud.controller;

import com.demo.springcloud.entity.ElasticsearchPhone;
import com.demo.springcloud.repository.ElasticsearchPhoneRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    //插入数据
    @GetMapping("/save")
    public void save() {
        ElasticsearchPhone phone = new ElasticsearchPhone(1, "诺基亚5300", "诺基亚");
    }

    //批量插入数据
    @GetMapping("/batchSave")
    public void batchSave() {
        List<ElasticsearchPhone> list = new ArrayList<>();
        ElasticsearchPhone phone2 = new ElasticsearchPhone(2, "小米", "小米12pro");
        ElasticsearchPhone phone3 = new ElasticsearchPhone(3, "苹果", "iphone12");
        list.add(phone2);
        list.add(phone3);
        phoneRepository.saveAll(list);
    }

}
