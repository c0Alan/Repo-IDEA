package com.mybatis.mapper;

import com.model.mybatis.TSysRolePermission;

public interface TSysRolePermissionMapper {
    int insert(TSysRolePermission record);

    int insertSelective(TSysRolePermission record);
}