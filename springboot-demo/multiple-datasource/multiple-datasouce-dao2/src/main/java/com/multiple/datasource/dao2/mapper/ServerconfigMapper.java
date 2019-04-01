package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Serverconfig;

public interface ServerconfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Serverconfig record);

    int insertSelective(Serverconfig record);

    Serverconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Serverconfig record);

    int updateByPrimaryKey(Serverconfig record);
}