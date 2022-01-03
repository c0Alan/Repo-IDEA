package com.demo.springcloud.service.impl;

import com.demo.springcloud.entity.User;
import com.demo.springcloud.mapper.UserMapper;
import com.demo.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxl
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> listUserByAge(int age){
        return userMapper.listUserByAge(age);
    }

}
