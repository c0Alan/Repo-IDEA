package com.service.redfox;

import com.github.pagehelper.PageHelper;
import com.mapper.redfox.UserMapper;
import com.model.redfox.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Map findAllUser(int pageNum, int pageSiez){
        Map resultMap = new HashMap();
        Integer cnt = userMapper.selectCount();
        resultMap.put("count", cnt);
        PageHelper.startPage(pageNum, pageSiez);
        List<User> userList = userMapper.selectAllUser();
        resultMap.put("list", userList);
        return resultMap;
    }
}
