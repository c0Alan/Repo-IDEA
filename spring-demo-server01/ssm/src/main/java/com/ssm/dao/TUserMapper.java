package com.ssm.dao;


import com.ssm.entity.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    /**
     * 根据用户名, 密码获取登录用户
     * @return
     */
    TUser selectUser(TUser user);
}