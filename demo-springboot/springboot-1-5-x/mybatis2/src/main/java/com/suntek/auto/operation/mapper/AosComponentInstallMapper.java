package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosComponentInstall;

public interface AosComponentInstallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosComponentInstall record);

    int insertSelective(AosComponentInstall record);

    AosComponentInstall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosComponentInstall record);

    int updateByPrimaryKey(AosComponentInstall record);
}