package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosOperationLog;

public interface AosOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosOperationLog record);

    int insertSelective(AosOperationLog record);

    AosOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosOperationLog record);

    int updateByPrimaryKey(AosOperationLog record);
}