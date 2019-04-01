package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Consumertoken;

public interface ConsumertokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumertoken record);

    int insertSelective(Consumertoken record);

    Consumertoken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consumertoken record);

    int updateByPrimaryKey(Consumertoken record);
}