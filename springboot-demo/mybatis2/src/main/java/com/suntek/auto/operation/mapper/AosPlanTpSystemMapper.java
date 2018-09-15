package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosPlanTpSystem;

public interface AosPlanTpSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosPlanTpSystem record);

    int insertSelective(AosPlanTpSystem record);

    AosPlanTpSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosPlanTpSystem record);

    int updateByPrimaryKey(AosPlanTpSystem record);
}