package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Instance;

public interface InstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Instance record);

    int insertSelective(Instance record);

    Instance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);
}