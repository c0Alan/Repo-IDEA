package com.sch.service.impl;

import com.sch.entity.TUser;
import com.sch.mapper.TUserMapper;
import com.sch.service.TUserService;
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
