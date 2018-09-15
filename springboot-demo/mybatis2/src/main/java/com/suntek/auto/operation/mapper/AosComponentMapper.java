package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosComponent;

public interface AosComponentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosComponent record);

    int insertSelective(AosComponent record);

    AosComponent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosComponent record);

    int updateByPrimaryKey(AosComponent record);
}