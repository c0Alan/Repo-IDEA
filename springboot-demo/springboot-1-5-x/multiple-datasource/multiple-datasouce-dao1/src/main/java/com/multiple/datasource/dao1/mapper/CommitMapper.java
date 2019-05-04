package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Commit;

public interface CommitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commit record);

    int insertSelective(Commit record);

    Commit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commit record);

    int updateByPrimaryKeyWithBLOBs(Commit record);

    int updateByPrimaryKey(Commit record);
}