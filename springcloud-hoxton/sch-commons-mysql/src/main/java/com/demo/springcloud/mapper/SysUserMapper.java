package com.demo.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.springcloud.entity.SysUser;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-09-07 22:07:22
* @Entity com.demo.springcloud.entity.SysUser
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectListByUsername(String username);

}




