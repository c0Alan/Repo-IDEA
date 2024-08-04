package com.demo.springcloud.sse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.springcloud.entity.TOrder;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
public interface TOrderService extends IService<TOrder> {

    void create(String userId, String commodityCode, int orderCount);
}
