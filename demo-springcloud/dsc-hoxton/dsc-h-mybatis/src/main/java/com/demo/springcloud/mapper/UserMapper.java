package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.User;


public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}