package com.mybatis.mapper;

import com.mybatis.model.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}