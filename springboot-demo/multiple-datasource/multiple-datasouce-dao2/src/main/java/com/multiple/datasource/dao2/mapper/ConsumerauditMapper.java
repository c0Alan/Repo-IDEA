package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Consumeraudit;

public interface ConsumerauditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumeraudit record);

    int insertSelective(Consumeraudit record);

    Consumeraudit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consumeraudit record);

    int updateByPrimaryKey(Consumeraudit record);
}