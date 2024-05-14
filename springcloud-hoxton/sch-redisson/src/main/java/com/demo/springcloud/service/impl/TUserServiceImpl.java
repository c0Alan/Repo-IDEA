package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.TUserMapper;
import com.demo.springcloud.service.TUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 服务实现类
 * </p>
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
