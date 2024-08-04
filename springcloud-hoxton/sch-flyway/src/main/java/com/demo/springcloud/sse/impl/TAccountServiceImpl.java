package com.demo.springcloud.sse.impl;

import com.demo.springcloud.entity.TAccount;
import com.demo.springcloud.mapper.TAccountMapper;
import com.demo.springcloud.sse.TAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {

}
