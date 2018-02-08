package com.service.mybatis.impl;

import com.github.pagehelper.PageHelper;
import com.model.mybatis.TUser;
import com.mybatis.mapper.TUserMapper;
import com.service.mybatis.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TUserService implements IUserService<TUser> {
    @Autowired
    TUserMapper tUserMapper;

    public void addUser(TUser user){
        tUserMapper.insert(user);
    }


    public Map getAllUser(int pageNum, int pageSiez) {
        List<TUser> users = tUserMapper.selectAll();

        Map resultMap = new HashMap();
        Integer cnt = tUserMapper.selectCount();
        resultMap.put("count", cnt);
        PageHelper.startPage(pageNum, pageSiez);
        List<TUser> userList = tUserMapper.selectAll();
        resultMap.put("list", userList);
        return resultMap;
    }
}
