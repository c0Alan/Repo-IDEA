package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Namespace;

public interface NamespaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Namespace record);

    int insertSelective(Namespace record);

    Namespace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Namespace record);

    int updateByPrimaryKey(Namespace record);
}