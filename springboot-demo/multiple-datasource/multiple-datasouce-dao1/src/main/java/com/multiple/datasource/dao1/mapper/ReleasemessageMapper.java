package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Releasemessage;

public interface ReleasemessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Releasemessage record);

    int insertSelective(Releasemessage record);

    Releasemessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Releasemessage record);

    int updateByPrimaryKey(Releasemessage record);
}