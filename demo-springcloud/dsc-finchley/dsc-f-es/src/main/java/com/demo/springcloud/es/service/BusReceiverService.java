package com.demo.springcloud.es.service;

import com.demo.springcloud.es.entity.BusReceiverEntity;

import java.util.List;
import java.util.Map;

public interface BusReceiverService {

    List<BusReceiverEntity> queryPage();

    BusReceiverEntity queryObject(Long id);

    void save(BusReceiverEntity t);

    void saveBatch(List<BusReceiverEntity> list);

    List<BusReceiverEntity> queryList(Map<String, Object> map);

    void update(BusReceiverEntity t);

    void delete(Long id);

    void deleteAll();

    List<BusReceiverEntity> queryByName(String name);
}