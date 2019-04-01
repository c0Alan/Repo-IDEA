package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Audit;

public interface AuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}