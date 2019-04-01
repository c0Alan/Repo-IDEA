package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Cluster;

public interface ClusterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cluster record);

    int insertSelective(Cluster record);

    Cluster selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cluster record);

    int updateByPrimaryKey(Cluster record);
}