package com.demo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.TestUser;
import com.demo.springcloud.service.TestUserService;
import com.demo.springcloud.mapper.TestUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【test_user(测试-用户信息表)】的数据库操作Service实现
* @createDate 2024-09-07 22:20:03
*/
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser>
    implements TestUserService{

}




