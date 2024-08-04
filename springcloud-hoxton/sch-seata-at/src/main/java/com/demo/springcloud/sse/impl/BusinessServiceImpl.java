/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.demo.springcloud.sse.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.springcloud.entity.TAccount;
import com.demo.springcloud.entity.TStorage;
import com.demo.springcloud.sse.BusinessService;
import com.demo.springcloud.sse.TAccountService;
import com.demo.springcloud.sse.TOrderService;
import com.demo.springcloud.sse.TStorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * The type Business service.
 *
 * @author jimin.jm @alibaba-inc.com
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private TStorageService storageService;

    @Autowired
    private TOrderService orderService;

    @Autowired
    private TAccountService accountService;


    private final Random random = new Random();

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-seata-tx")
    public void purchase(String userId, String commodityCode, int orderCount) {
        log.info("purchase begin ... xid: " + RootContext.getXID());
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
        if (random.nextBoolean()) {
            throw new RuntimeException("random exception mock!");
        }
    }

//    @PostConstruct
    public void initData() {
        storageService.remove(new QueryWrapper<>());
        orderService.remove(new QueryWrapper<>());
        accountService.remove(new QueryWrapper<>());
        accountService.save(new TAccount(1, "U100001", "U100001", 10000));
        storageService.save(new TStorage(1, "C100001", 10000));
    }

}
