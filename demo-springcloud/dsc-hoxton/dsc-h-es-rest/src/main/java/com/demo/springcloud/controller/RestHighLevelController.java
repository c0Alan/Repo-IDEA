package com.demo.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.demo.springcloud.entity.Person;
import com.demo.springcloud.service.PersonService;
import com.demo.springcloud.service.ToolFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 参考: https://gitee.com/xkcoding/spring-boot-demo/tree/master/demo-elasticsearch-rest-high-level-client
 * @author liuxilin
 * @date 2022年03月11日 12:37
 */
@Slf4j
@RequestMapping("/restHighLevel")
@RestController
public class RestHighLevelController {
    @Autowired
    PersonService personService;

    @Autowired
    ToolFileService toolFileService;

    @GetMapping("/createIndexByJson")
    public Object createIndexByJson(@RequestParam String indexName) {
        JSONObject source = toolFileService.getJsonFile(indexName + ".json");
        Object result = personService.createIndex(indexName, source);
        return result;
    }

    @GetMapping("/createIndex")
    public Object createIndex() {
        Object result = personService.createIndex("idx_dsc_person");

        return result;
    }

    /**
     * 更新索引mapping, es7只能加字段, 不能修改类型跟删字段
     * @param indexName
     * @return
     */
    @GetMapping("/updateIndexByJson")
    public Object updateIndexByJson(@RequestParam String indexName) {
        JSONObject source = toolFileService.getJsonFile(indexName + ".json");
        Object result = personService.updateIndexMapping(indexName, source.getJSONObject("mappings"));
        return result;
    }

    @GetMapping("/insertAll")
    public Object insertAll() {
        List<Person> list = new ArrayList<>();
        list.add(Person.builder().age(11).birthday(new Date()).country("CN").id(1L).name("王勃").remark("test1").build());
        list.add(Person.builder().age(22).birthday(new Date()).country("US").id(2L).name("李白").remark("test2").build());
        list.add(Person.builder().age(33).birthday(new Date()).country("ID").id(3L).name("孟浩然").remark("test3").build());
        list.add(Person.builder().age(23).birthday(new Date()).country("ID").id(4L).name("王安石").remark("test4").build());
        list.add(Person.builder().age(28).birthday(new Date()).country("ID").id(5L).name("张三丰").remark("test5").build());

        List result = personService.insertAll("idx_dsc_person", list);
        return result;
    }

    @GetMapping("/updateAll")
    public Object updateAll() {
        Person person = Person.builder().
                age(33).
                birthday(new Date()).
                country("ID_update").
                id(3L).
                name("呵呵update").
                remark("test3_update").build();
        List<Person> list = new ArrayList<>();
        list.add(person);

        List result = personService.updateAll("idx_dsc_person", list);
        return result;
    }

    @GetMapping("/deleteById")
    public Object deleteById() {
        List result = personService.delete("idx_dsc_person", Person.builder().id(1L).build());
        return result;
    }

    @GetMapping("/searchAll")
    public Object searchAll() {
        List result = personService.searchList("idx_dsc_person");
        return result;
    }

    @GetMapping("/searchPersonByName")
    public Object searchPersonByName() throws IOException {
        List result = personService.searchPersonByName();
        return result;
    }
}
