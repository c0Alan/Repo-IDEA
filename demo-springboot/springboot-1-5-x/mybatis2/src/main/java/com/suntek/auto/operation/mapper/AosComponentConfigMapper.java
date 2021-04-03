package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosComponentConfig;

public interface AosComponentConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosComponentConfig record);

    int insertSelective(AosComponentConfig record);

    AosComponentConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosComponentConfig record);

    int updateByPrimaryKey(AosComponentConfig record);
}