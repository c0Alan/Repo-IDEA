package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.TOrder;
import com.demo.springcloud.mapper.TOrderMapper;
import com.demo.springcloud.service.TAccountService;
import com.demo.springcloud.service.TOrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Slf4j
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {
    @Autowired
    private TAccountService accountService;

    @Override
    public void create(String userId, String commodityCode, int count) {
        log.info("Order Service Begin ... xid: " + RootContext.getXID());
        TOrder order = new TOrder();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        int orderMoney = calculate(commodityCode, count);
        order.setMoney(orderMoney);

        baseMapper.insert(order);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        accountService.debit(userId, orderMoney);

    }

    private int calculate(String commodityCode, int count) {
        return 200 * count;
    }
}
