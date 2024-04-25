package com.demo.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserService.class, version = "2.6.0", timeout = 15000)
public class UserServiceImpl implements UserService {
    @Override
    public int getCount() {
        //调用数据持久层
        return 1024;
    }
}
