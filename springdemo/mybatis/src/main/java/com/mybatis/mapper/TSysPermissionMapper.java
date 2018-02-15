package com.mybatis.mapper;

import com.model.mybatis.TSysPermission;

public interface TSysPermissionMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(TSysPermission record);

    int insertSelective(TSysPermission record);

    TSysPermission selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(TSysPermission record);

    int updateByPrimaryKey(TSysPermission record);
}