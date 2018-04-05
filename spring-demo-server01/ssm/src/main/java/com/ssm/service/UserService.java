package com.ssm.service;

import com.ssm.dao.TUserMapper;
import com.ssm.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    TUserMapper tUserMapper;
    public TUser getUserById(Integer id){
        return tUserMapper.selectByPrimaryKey(id);
    }

    public TUser getUser(TUser user){
        TUser u = tUserMapper.selectUser(user);
        return u;
    }
}
