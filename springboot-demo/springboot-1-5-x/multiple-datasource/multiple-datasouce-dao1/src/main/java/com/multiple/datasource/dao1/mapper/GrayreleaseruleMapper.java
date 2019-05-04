package com.multiple.datasource.dao1.mapper;

import com.multiple.datasource.dao1.entity.Grayreleaserule;

public interface GrayreleaseruleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grayreleaserule record);

    int insertSelective(Grayreleaserule record);

    Grayreleaserule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grayreleaserule record);

    int updateByPrimaryKey(Grayreleaserule record);
}