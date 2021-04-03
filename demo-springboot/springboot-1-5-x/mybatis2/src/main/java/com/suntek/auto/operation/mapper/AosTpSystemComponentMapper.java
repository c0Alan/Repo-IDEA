package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosTpSystemComponent;

public interface AosTpSystemComponentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosTpSystemComponent record);

    int insertSelective(AosTpSystemComponent record);

    AosTpSystemComponent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosTpSystemComponent record);

    int updateByPrimaryKey(AosTpSystemComponent record);
}