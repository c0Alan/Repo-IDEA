package com.demo.springcloud.service;


import com.demo.springcloud.entity.SysUser;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: torlesse-liang
 * @Date: 2022/04/11/22:40
 * @Description: UserSerivce
 */
public interface SysUserSerivce {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public SysUser queryByUserName(String username);
}
