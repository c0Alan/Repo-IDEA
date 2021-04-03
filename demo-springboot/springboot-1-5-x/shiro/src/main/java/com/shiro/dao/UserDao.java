package com.shiro.dao;

import com.shiro.model.TUser;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<TUser,Long> {
    /**通过username查找用户信息;*/
    public TUser findByCLoginid(String username);
}