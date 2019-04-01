package com.multiple.datasource.dao2.mapper;

import com.multiple.datasource.dao2.entity.Favorite;

public interface FavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}