package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosPlan;

public interface AosPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosPlan record);

    int insertSelective(AosPlan record);

    AosPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosPlan record);

    int updateByPrimaryKey(AosPlan record);
}