package com.mybatis.mapper;

import com.model.mybatis.TSysRole;

public interface TSysRoleMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(TSysRole record);

    int insertSelective(TSysRole record);

    TSysRole selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(TSysRole record);

    int updateByPrimaryKey(TSysRole record);
}