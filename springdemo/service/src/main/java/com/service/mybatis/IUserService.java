package com.service.mybatis;

import java.util.List;

/**
 * 用戶服務类
 */
public interface IUserService<T> {
    public void addUser(T user);

}
