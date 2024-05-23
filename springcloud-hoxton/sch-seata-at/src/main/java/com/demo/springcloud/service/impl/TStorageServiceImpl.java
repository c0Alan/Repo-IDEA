package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.TStorage;
import com.demo.springcloud.mapper.TStorageMapper;
import com.demo.springcloud.service.TStorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 仓库表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Slf4j
@Service
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements TStorageService {

    @Override
    public void deduct(String commodityCode, int count) {
        log.info("Stock Service Begin ... xid: " + RootContext.getXID());
        log.info("Deducting inventory SQL: update stock_tbl set count = count - {} where commodity_code = {}", count, commodityCode);

        TStorage stock = baseMapper.selectOne(new QueryWrapper<TStorage>().eq("commodity_code", commodityCode));
        stock.setCount(stock.getCount() - count);
        baseMapper.updateById(stock);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Stock Service End ... ");
    }
}
