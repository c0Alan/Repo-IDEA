package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Consumerrole;

public interface ConsumerroleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumerrole record);

    int insertSelective(Consumerrole record);

    Consumerrole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consumerrole record);

    int updateByPrimaryKey(Consumerrole record);
}