package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosPlanComponentList;

public interface AosPlanComponentListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosPlanComponentList record);

    int insertSelective(AosPlanComponentList record);

    AosPlanComponentList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosPlanComponentList record);

    int updateByPrimaryKey(AosPlanComponentList record);
}