package com.demo.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.springcloud.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @Author: torlesse-liang
 * @Date: 2022/04/11/22:35
 * @Description: UserMapper
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @Select("select username,password,enabled from t_user where username = #{username} and enabled = 1")
    SysUser queryUserByUserName(@Param("username") String username);
}
