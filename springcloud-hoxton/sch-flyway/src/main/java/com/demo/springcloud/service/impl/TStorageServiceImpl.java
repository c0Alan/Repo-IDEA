package com.demo.springcloud.service.impl;

import com.demo.springcloud.entity.TStorage;
import com.demo.springcloud.mapper.TStorageMapper;
import com.demo.springcloud.service.TStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Service
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements TStorageService {

}
