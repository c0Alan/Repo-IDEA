package com.mybatis.mapper;

import com.model.mybatis.TSysUserRole;

public interface TSysUserRoleMapper {
    int insert(TSysUserRole record);

    int insertSelective(TSysUserRole record);
}