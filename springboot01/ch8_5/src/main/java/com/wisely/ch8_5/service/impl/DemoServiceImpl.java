package com.wisely.ch8_5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wisely.ch8_5.dao.PersonRepository;
import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;


@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    /**
     * 插入的数据也会做缓存
     * @param person
     * @return
     */
    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    /**
     * 这里会清除缓存, 数据会再次进行查库
     * @param id
     */
    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    /**
     * 这里会走缓存
     *
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "people", key = "#person.id")//3
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

}
