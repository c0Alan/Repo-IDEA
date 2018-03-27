package com.wisely.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wisely.ui.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用Person Service 的断路器:
 * 
 * @author liuxl
 * @date 2018/3/26 23:28
 */
@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    /**
     * 使用@HystrixCommand 的fallbac灿街thod 参数指定，当本方法调用失败时，
     * 调用后备方法fallbackSave 。
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackSave") //
    public List<Person> save(String name) {
        return personService.save(name);
    }

    /**
     *
     *
     * @author liuxl
     * @date 2018/3/26 23:29
     * @param [name]
     * @return java.util.List<com.wisely.ui.domain.Person>
     */
    public List<Person> fallbackSave(String name) {
        List<Person> list = new ArrayList<>();
        Person p = new Person(name + "没有保存成功，Person Service 故障");
        list.add(p);
        return list;
    }
}
