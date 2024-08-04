package com.demo.springcloud.sse.impl;

import com.demo.springcloud.entity.TOrder;
import com.demo.springcloud.mapper.TOrderMapper;
import com.demo.springcloud.sse.TOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

}
