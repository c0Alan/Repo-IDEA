package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosFunctionCheckResult;

public interface AosFunctionCheckResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosFunctionCheckResult record);

    int insertSelective(AosFunctionCheckResult record);

    AosFunctionCheckResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosFunctionCheckResult record);

    int updateByPrimaryKey(AosFunctionCheckResult record);
}