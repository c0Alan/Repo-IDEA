package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.TestAccount;
import com.demo.springcloud.mapper.TestAccountMapper;
import com.demo.springcloud.service.TestAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Administrator
* @description 针对表【test_account(账户表)】的数据库操作Service实现
* @createDate 2024-09-08 18:09:40
*/
@Slf4j
@Service
public class TestAccountServiceImpl extends ServiceImpl<TestAccountMapper, TestAccount> implements TestAccountService{

    @Transactional(rollbackFor = Exception.class)
    public void updateAndRollback(TestAccount testAccount) {

        updateById(testAccount);
        log.info("updateAndRollback");
        int a = 10 / 0;
    }

    public void updateNotRollback(TestAccount testAccount) {

        updateById(testAccount);
        int a = 10 / 0;
    }

}




