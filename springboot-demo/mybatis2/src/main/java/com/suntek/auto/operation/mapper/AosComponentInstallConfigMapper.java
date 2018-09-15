package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosComponentInstallConfig;

public interface AosComponentInstallConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosComponentInstallConfig record);

    int insertSelective(AosComponentInstallConfig record);

    AosComponentInstallConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosComponentInstallConfig record);

    int updateByPrimaryKey(AosComponentInstallConfig record);
}