package com.hibernate;

import com.model.hibernate.TUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<TUser,Long> {
    /**通过username查找用户信息;*/
    public TUser findByUsername(String username);
}