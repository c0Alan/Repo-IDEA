package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Namespacelock;

public interface NamespacelockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Namespacelock record);

    int insertSelective(Namespacelock record);

    Namespacelock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Namespacelock record);

    int updateByPrimaryKey(Namespacelock record);
}