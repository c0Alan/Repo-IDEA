package com.demo.springcloud.service.impl;


import com.demo.springcloud.entity.UserInfo;
import com.demo.springcloud.mapper.UserMapper;
import com.demo.springcloud.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: torlesse-liang
 * @Date: 2022/04/11/22:40
 * @Description: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserSerivce {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo queryByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }
}
