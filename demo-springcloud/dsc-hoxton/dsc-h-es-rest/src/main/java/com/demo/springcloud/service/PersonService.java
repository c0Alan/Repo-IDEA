package com.demo.springcloud.service;

import cn.hutool.json.JSONObject;
import com.demo.springcloud.entity.Person;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author liuxilin
 * @date 2022/3/13 21:43
 */
public interface PersonService {

    /**
     * 创建索引
     * @param index
     * @return
     */
    CreateIndexResponse createIndex(String index);

    /**
     * 根据脚本创建索引
     * @param index
     * @param source
     * @return
     */
    CreateIndexResponse createIndex(String index, JSONObject source);

    AcknowledgedResponse updateIndexMapping(String index, JSONObject source);

    /**
     * 删除索引
     * @param index
     */
    void deleteIndex(String index);

    /**
     * 新增数据
     * @param index
     * @param list
     * @return
     */
    List insertAll(String index, List<Person> list);

    /**
     * 更新数据
     * @param index
     * @param list
     * @return
     */
    List updateAll(String index, List<Person> list);

    /**
     * 删除数据
     * @param index
     * @param person
     * @return
     */
    List delete(String index, @Nullable Person person);

    /**
     * 搜索所有数据
     * @param index
     * @return
     */
    List<Person> searchList(String index);

    /**
     * 根据 name 字段搜索
     * @return
     * @throws IOException
     */
    List<Person> searchPersonByName() throws IOException;

}
