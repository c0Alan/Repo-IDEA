package com.sch.jdbc;


import com.sch.entity.User;

import java.util.List;

/**
 * @author liuxl
 */
public interface UserService {
    /**
     * 写入数据
     * @return
     */
    int saveUser();

    /**
     * 查询数据
     * @return
     */
    List<User> queryAllUser();

    /**
     * 更新数据
     * @param User
     * @return
     */
    int updateUser(User User);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteUser(Integer id);

}
