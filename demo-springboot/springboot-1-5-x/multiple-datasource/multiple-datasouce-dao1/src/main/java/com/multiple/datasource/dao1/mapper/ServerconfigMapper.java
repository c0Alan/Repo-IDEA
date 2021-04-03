package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Serverconfig;

public interface ServerconfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Serverconfig record);

    int insertSelective(Serverconfig record);

    Serverconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Serverconfig record);

    int updateByPrimaryKey(Serverconfig record);
}