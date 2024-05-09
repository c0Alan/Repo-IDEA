package com.demo.springcloud.service.impl;

import com.demo.springcloud.mapper.TUserMapper;
import com.demo.springcloud.service.TUserService;
import com.sch.entity.TUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxilin
 * @since 2023-08-15
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}