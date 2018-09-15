package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosDbVersion;

public interface AosDbVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosDbVersion record);

    int insertSelective(AosDbVersion record);

    AosDbVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosDbVersion record);

    int updateByPrimaryKey(AosDbVersion record);
}