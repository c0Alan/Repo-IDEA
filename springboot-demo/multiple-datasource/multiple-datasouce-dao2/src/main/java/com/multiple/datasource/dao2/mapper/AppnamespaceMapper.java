package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Appnamespace;

public interface AppnamespaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appnamespace record);

    int insertSelective(Appnamespace record);

    Appnamespace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appnamespace record);

    int updateByPrimaryKey(Appnamespace record);
}