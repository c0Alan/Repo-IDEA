package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosExecCommand;

public interface AosExecCommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosExecCommand record);

    int insertSelective(AosExecCommand record);

    AosExecCommand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosExecCommand record);

    int updateByPrimaryKey(AosExecCommand record);
}