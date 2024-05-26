package com.demo.java.web.service;

import com.demo.java.web.domain.User;
import com.demo.java.web.exception.UserExistException;

public interface IUserService {

    /**
     * 提供注册服务
     */
    void registerUser(User user) throws UserExistException;

    /**
     * 提供登录服务
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String userName, String userPwd);
}