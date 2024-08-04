package com.demo.springcloud.sse.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.TUserMapper;
import com.demo.springcloud.sse.TUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 服务实现类
 *
 * @author liuxilin
 * @since 2023-08-15
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, SysUser> implements TUserService {

    @Override
    @Cacheable(value = "userCache", key = "#id", cacheManager = "cacheManager")
    public SysUser getById(Serializable id) {
        return baseMapper.selectById(id);
    }

}
