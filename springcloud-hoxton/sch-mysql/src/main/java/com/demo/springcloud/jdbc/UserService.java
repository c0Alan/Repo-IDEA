package com.demo.springcloud.jdbc;


import com.demo.springcloud.entity.SysUser;

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
    List<SysUser> queryAllUser();

    /**
     * 更新数据
     * @param SysUser
     * @return
     */
    int updateUser(SysUser SysUser);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteUser(Integer id);

}
