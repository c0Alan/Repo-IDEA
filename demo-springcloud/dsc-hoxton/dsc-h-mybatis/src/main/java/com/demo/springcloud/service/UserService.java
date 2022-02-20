package com.demo.springcloud.service;

import com.demo.springcloud.entity.User;

import java.util.List;

/**
 * @author liuxl
 */
public interface UserService {

    /**
     * 新增单个用户
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    public User getUserById(int id);

    /**
     * 根据年龄查询用户
     * @param age
     * @return
     */
    public List<User> listUserByAge(int age);

    int saveUserList(List<User> userList);
}
