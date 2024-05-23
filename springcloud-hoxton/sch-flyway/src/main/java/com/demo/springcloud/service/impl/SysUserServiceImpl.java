package com.demo.springcloud.service.impl;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
