package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosHostInfo;

public interface AosHostInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosHostInfo record);

    int insertSelective(AosHostInfo record);

    AosHostInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosHostInfo record);

    int updateByPrimaryKey(AosHostInfo record);
}