package com.demo.springcloud.controller;

import com.demo.springcloud.entity.DocBean;
import com.demo.springcloud.repository.ElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuxilin
 * @date 2022年03月11日 13:01
 */
@RequestMapping("/repository")
@RestController
public class RepositoryController {

    @Autowired
    private ElasticRepository elasticRepository;

    @GetMapping("/save")
    public Object save() {
        DocBean docBean = new DocBean(3L, "XX0257", "XX8097", "xxxxxxxxxxxxxxxxxx", 1);
        Object result = elasticRepository.save(docBean);

        return result;
    }

    @GetMapping("/saveAll")
    public Object saveAll() {
        List<DocBean> list = new ArrayList<>();
        list.add(new DocBean(1L, "XX0193", "XX8064", "xxxxxx", 1));
        list.add(new DocBean(2L, "XX0210", "XX7475", "xxxxxxxxxx", 1));
        list.add(new DocBean(3L, "XX0257", "XX8097", "xxxxxxxxxxxxxxxxxx", 1));
        Object result = elasticRepository.saveAll(list);

        return result;
    }

    /**
     * 按内容查询
     * @return
     */
    @GetMapping("/findByContent")
    Page<DocBean> findByContent(@RequestParam String content) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<DocBean> docBeans = elasticRepository.findByContent(content, pageable);
        return docBeans;
    }

    @GetMapping("/findAll")
    public Iterator<DocBean> findAll() {
        return elasticRepository.findAll().iterator();
    }
}
