package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Release;

public interface ReleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Release record);

    int insertSelective(Release record);

    Release selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Release record);

    int updateByPrimaryKeyWithBLOBs(Release record);

    int updateByPrimaryKey(Release record);
}