package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosFunctionCheck;

public interface AosFunctionCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosFunctionCheck record);

    int insertSelective(AosFunctionCheck record);

    AosFunctionCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosFunctionCheck record);

    int updateByPrimaryKey(AosFunctionCheck record);
}