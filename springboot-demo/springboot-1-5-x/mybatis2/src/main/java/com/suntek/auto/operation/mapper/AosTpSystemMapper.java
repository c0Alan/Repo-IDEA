package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosTpSystem;

public interface AosTpSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosTpSystem record);

    int insertSelective(AosTpSystem record);

    AosTpSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosTpSystem record);

    int updateByPrimaryKey(AosTpSystem record);
}