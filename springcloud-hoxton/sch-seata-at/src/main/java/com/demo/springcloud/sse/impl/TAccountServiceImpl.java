package com.demo.springcloud.sse.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.TAccount;
import com.demo.springcloud.mapper.TAccountMapper;
import com.demo.springcloud.sse.TAccountService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Slf4j
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {
    @Autowired
    private TAccountMapper tAccountMapper;

    @Override
    public void debit(String userId, int money) {
        log.info("Account Service ... xid: " + RootContext.getXID());
        log.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}", money, userId);
        TAccount account = baseMapper.selectOne(new QueryWrapper<TAccount>().eq("user_id", userId));
        account.setMoney(money);
        baseMapper.updateById(account);
        log.info("Account Service End ... ");
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-seata-tx")
    public void addMoney(String userId, int money) {
        log.info("addMoney事务开始================================================================");
        tAccountMapper.addMoney(userId, money);
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("addMoney事务结束================================================================");
    }
}
