package com.demo.springcloud.sse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.springcloud.entity.TAccount;

/**
 * <p>
 * 账户表 服务类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
public interface TAccountService extends IService<TAccount> {

    void debit(String userId, int orderMoney);

    void addMoney(String userId, int money);
}
