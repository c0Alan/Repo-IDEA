package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Releasehistory;

public interface ReleasehistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Releasehistory record);

    int insertSelective(Releasehistory record);

    Releasehistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Releasehistory record);

    int updateByPrimaryKeyWithBLOBs(Releasehistory record);

    int updateByPrimaryKey(Releasehistory record);
}