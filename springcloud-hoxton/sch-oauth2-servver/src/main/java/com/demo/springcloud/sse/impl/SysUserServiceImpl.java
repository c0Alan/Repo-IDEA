package com.demo.springcloud.sse.impl;


import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.sse.SysUserSerivce;
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
public class SysUserServiceImpl implements SysUserSerivce {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryByUserName(String username) {
        return sysUserMapper.queryUserByUserName(username);
    }
}
