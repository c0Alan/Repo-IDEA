package com.mybatis.service;

import com.mybatis.mapper.TUserMapper;
import com.mybatis.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    TUserMapper tUserMapper;
    public TUser getUserById(Integer id){
        return tUserMapper.selectByPrimaryKey(id);
    }
}
