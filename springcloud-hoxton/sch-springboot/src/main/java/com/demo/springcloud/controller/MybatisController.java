package com.demo.springcloud.controller;

import com.demo.springcloud.entity.TestUser;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * mybatis接口示例
 * 参考：https://blog.csdn.net/xu7382/article/details/139811192
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(tags = "mybatis接口示例")
@RestController
@Slf4j
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    private TestUserService testUserService;

    @ApiOperation(value = "getAllUser")
    @GetMapping("/getAllUser")
    public ResponseResult<List<TestUser>> getAllUser() {
        return ResponseResult.success(testUserService.list());
    }

}
