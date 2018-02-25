package com.demo.service;

import com.demo.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    HelloDao helloDao;

    public void sayHello(){
        System.out.println(helloDao.hello());
    }
}
