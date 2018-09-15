package com.suntek.auto.operation.mapper;

import com.suntek.auto.operation.entity.AosPackageManagement;

public interface AosPackageManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AosPackageManagement record);

    int insertSelective(AosPackageManagement record);

    AosPackageManagement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AosPackageManagement record);

    int updateByPrimaryKey(AosPackageManagement record);
}