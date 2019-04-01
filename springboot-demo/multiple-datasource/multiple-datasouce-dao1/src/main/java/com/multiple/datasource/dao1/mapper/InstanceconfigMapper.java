package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Instanceconfig;

public interface InstanceconfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Instanceconfig record);

    int insertSelective(Instanceconfig record);

    Instanceconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Instanceconfig record);

    int updateByPrimaryKey(Instanceconfig record);
}