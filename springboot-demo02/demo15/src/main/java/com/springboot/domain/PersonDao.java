package com.springboot.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.springboot.dao.Person;

@Repository
public class PersonDao {
    // Spring Boot 已为我们配置StringRedisTemplate ，在此处可以直接注入。
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // Spring Boot 己为我们配置了RedisTemplate ，在此处可以直接注入O
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    // 可以使用@Resource 注解指定stringRedisTemplate ，可注入基于字符串的简单属性操作方法。
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    // 可以使用@Resource 注解指定redisTemplate ，可注入基于对象的简单属性操作方法;
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo() {
        valOpsStr.set("xx", "yy");
    }

    public void save(Person person) {
        valOps.set(person.getId(), person);
    }

    public String getString() {
        return valOpsStr.get("xx");
    }

    public Person getPerson() {
        return (Person) valOps.get("1");
    }

}
