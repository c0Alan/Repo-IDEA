package com.demo.springcloud.controller;

import com.demo.springcloud.enums.PublicEnum;
import com.demo.springcloud.entity.BaseController;
import com.demo.springcloud.entity.Result;
import com.demo.springcloud.entity.SysRole;
import com.demo.springcloud.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 角色信息
 *
 * @author lc
 */

@Api(tags = "权限管理")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/system/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增角色
     */
    @ApiOperation(value = "新增权限", notes = "新增权限")
    @PostMapping
    public Result add(@Validated @RequestBody SysRole role) {
        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysRoleService.checkRoleNameUnique(role))) {
            return error("新增权限'" + role.getRoleName() + "'失败，权限名称已存在");
        }
        return success(sysRoleService.insertRole(role));

    }

    /**
     * 修改保存权限
     */
    @ApiOperation(value = "修改保存权限", notes = "修改保存权限")
    @PutMapping
    public Result edit(@Validated @RequestBody SysRole role) {
        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysRoleService.checkRoleNameUnique(role))) {
            return error("修改权限'" + role.getRoleName() + "'失败，权限名称已存在");
        }
        return success(sysRoleService.updateRole(role));
    }

    /**
     * 状态修改
     */
    @ApiOperation(value = "状态修改", notes = "状态修改")
    @PutMapping("/changeStatus")
    public Result changeStatus(@RequestBody SysRole role) {
        return success(sysRoleService.updateRoleStatus(role));
    }

    /**
     * 删除权限
     */
    @ApiOperation(value = "删除权限", notes = "删除权限")
    @DeleteMapping("/{roleIds}")
    public Result remove(@PathVariable Long[] roleIds) {
        return success(sysRoleService.deleteRoleByIds(roleIds));
    }

    /**
     * 根据权限ID获取详细信息
     */
    @ApiOperation(value = "根据权限ID获取详细信息", notes = "根据权限ID获取详细信息")
    @GetMapping(value = "/{roleId}")
    public Result getInfo(@PathVariable Long roleId) {
        return success(sysRoleService.selectRoleById(roleId));
    }

    /**
     * selectRoleAll
     * 权限列表
     */
    @ApiOperation(value = "权限列表", notes = "权限列表")
    @GetMapping("/selectRoleAll")
    public Result selectRoleAll() {
        return success(sysRoleService.selectRoleAll());
    }
}
