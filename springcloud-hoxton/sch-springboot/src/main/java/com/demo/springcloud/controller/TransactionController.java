package com.demo.springcloud.controller;

import com.demo.springcloud.entity.TestAccount;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.impl.TestAccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库事务 接口示例
 * 参考：https://www.cnblogs.com/mysweetAngleBaby/p/16371735.html
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(tags = "transaction 接口示例")
@RestController
@Slf4j
@RequestMapping("/transaction")
public class TransactionController {
    private final TestAccountServiceImpl testAccountService;

    public TransactionController(TestAccountServiceImpl testAccountService) {
        this.testAccountService = testAccountService;
    }

    @ApiOperation(value = "getAllAccount")
    @GetMapping("/getAllAccount")
    public ResponseResult<List<TestAccount>> getAllAccount() {
        return ResponseResult.success(testAccountService.list());
    }

    @ApiOperation(value = "updateAndRollback")
    @PostMapping("/updateAndRollback")
    public ResponseResult updateAndRollback(@RequestBody TestAccount testAccount) {
        testAccountService.updateAndRollback(testAccount);

        return ResponseResult.success();
    }

    @ApiOperation(value = "updateNotRollback")
    @PostMapping("/updateNotRollback")
    public ResponseResult updateNotRollback(@RequestBody TestAccount testAccount) {

        testAccountService.updateNotRollback(testAccount);

        return ResponseResult.success();
    }

}
