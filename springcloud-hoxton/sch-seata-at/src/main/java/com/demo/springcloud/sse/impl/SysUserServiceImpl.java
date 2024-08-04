package com.demo.springcloud.sse.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.sse.SysUserService;
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
