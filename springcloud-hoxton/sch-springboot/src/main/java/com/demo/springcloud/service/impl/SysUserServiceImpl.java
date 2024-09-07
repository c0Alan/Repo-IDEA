package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.service.SysUserService;
import com.demo.springcloud.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2024-09-07 22:07:22
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




