package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosHostConfig;

public interface AosHostConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosHostConfig record);

    int insertSelective(AosHostConfig record);

    AosHostConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosHostConfig record);

    int updateByPrimaryKey(AosHostConfig record);
}