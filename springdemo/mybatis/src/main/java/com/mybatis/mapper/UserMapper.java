package com.mybatis.mapper;


import com.model.mybatis.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public Integer selectCount();

    public List<User> selectAllUser();
}