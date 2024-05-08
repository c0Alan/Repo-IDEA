package com.demo.springcloud.controller;

import com.demo.springcloud.entity.BaseController;
import com.demo.springcloud.entity.Result;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.enums.PublicEnum;
import com.demo.springcloud.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息
 *
 * @author li'chao
 */
@Api(tags = "用户管理")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增用户
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping
    public Result add(@Validated @RequestBody SysUser user) {
        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysUserService.checkLoginNameUnique(user))) {
            return error("新增用户'" + user.getUserName() + "'失败，登录名已存在");
        }
        return success(sysUserService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping
    public Result edit(@Validated @RequestBody SysUser user) {
        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysUserService.checkLoginNameUnique(user))) {
            return error("修改用户'" + user.getUserName() + "'失败，登录名已存在");
        }
        return success(sysUserService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/{userId}")
    public Result remove(@PathVariable Long userId) {
        return success(sysUserService.deleteUserById(userId));
    }

    /**
     * 重置密码
     */
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @PutMapping("/resetUserPwd")
    public Result resetUserPwd(@RequestBody SysUser user) {
        return success(sysUserService.resetUserPwd(user));
    }

    /**
     * 状态修改
     */
    @ApiOperation(value = "状态修改", notes = "状态修改")
    @PutMapping("/updateUserStatus")
    public Result updateUserStatus(@RequestBody SysUser user) {
        return success(sysUserService.updateUserStatus(user));
    }

    /**
     * 根据用户ID获取详细信息
     */
    @ApiOperation(value = "根据用户ID获取详细信息", notes = "根据用户ID获取详细信息")
    @GetMapping(value = "/{userId}")
    public Result selectUserByUserId(@PathVariable(value = "userId", required = true) Long userId) {
        return success(sysUserService.selectUserByUserId(userId));
    }

    /**
     * 根据条件分页查询用户列表
     */
    @ApiOperation(value = "根据条件分页查询用户列表", notes = "根据条件分页查询用户列表")
    @GetMapping("/selectUserList")
    public Result selectUserList(@Validated SysUser user, Integer page, Integer size) {
        return success(sysUserService.selectUserList(user, page, size));
    }

    /**
     * 根据ID修改用户密码
     */
    @ApiOperation(value = "根据ID修改用户密码", notes = "根据ID修改用户密码")
    @PostMapping("/updateUserPwd")
    public Result updateUserPwd(@RequestParam(value = "userId", required = true) Long userId,
                                @RequestParam(value = "oldPassword", required = true) String oldPassword,
                                @RequestParam(value = "newPassword", required = true) String newPassword) {
        return success(sysUserService.updateUserPwd(userId, oldPassword, newPassword));
    }
}
