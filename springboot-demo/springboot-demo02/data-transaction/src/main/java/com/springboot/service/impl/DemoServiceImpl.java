package com.springboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.PersonRepository;
import com.springboot.domain.Person;
import com.springboot.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository; //1

    /**
     * 只要抛出异常就回滚, 不管是不是IllegalArgumentException异常
     * rollbackFor 注释掉照样会回滚
     * @param person
     * @return
     */
    @Transactional(/*rollbackFor = {IllegalArgumentException.class}*/)
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

//        int a = 1/0;
        if (person.getName().equals("汪云飞")) {
            throw new IllegalArgumentException("汪云飞已存在，数据将回滚");
        }
        return p;
    }

    /**
     * 只有抛出IllegalArgumentException异常时才不会回滚, 其他异常都会回滚
     * @param person
     * @return
     */
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);

//        int a = 1/0;

        if (person.getName().equals("汪云飞")) {
            throw new IllegalArgumentException("汪云飞虽已存在，数据将不会回滚");
        }
        return p;
    }
}
