package com.spring.demo01.service;

import com.spring.demo01.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    private BaseDao<T> dao;

    public void addNew(T entity) {
        System.out.println("addNew by " + dao);
        dao.save(entity);
    }

}
