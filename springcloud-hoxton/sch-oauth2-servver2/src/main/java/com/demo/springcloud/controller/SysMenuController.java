package com.demo.springcloud.controller;


import com.demo.springcloud.entity.BaseController;
import com.demo.springcloud.entity.Result;
import com.demo.springcloud.entity.SysMenu;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.service.SysMenuService;
import com.demo.springcloud.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单信息
 *
 * @author lc
 */
@Api(tags = "菜单管理")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 新增菜单
     */
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @PostMapping
    public Result add(@Validated @RequestBody SysMenu menu) {
/*        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysMenuService.checkMenuNameUnique(menu)))
        {
            return error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }*/
        return success(sysMenuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    @PutMapping
    public Result edit(@Validated @RequestBody SysMenu menu) {
/*        if (PublicEnum.NOT_UNIQUE.getCode().equals(sysMenuService.checkMenuNameUnique(menu)))
        {
            return error("修改菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }*/
        return success(sysMenuService.updateMenu(menu));
    }

    /**
     * 删除菜单
     */
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @DeleteMapping("/{menuId}")
    public Result remove(@PathVariable("menuId") Long menuId) {
        if (sysMenuService.hasChildByMenuId(menuId)) {
            return error("存在子菜单,不允许删除");
        }
        if (sysMenuService.checkMenuExistRole(menuId)) {
            return error("菜单已分配,不允许删除");
        }
        return success(sysMenuService.deleteMenuById(menuId));
    }

    /**
     * 获取菜单列表
     */
    @ApiOperation(value = "获取菜单列表", notes = "获取菜单列表")
    @GetMapping("/selectMenuList")
    public Result selectMenuList() {
        return success(sysMenuService.selectMenuList());
    }

    /**
     * 获取菜单树列表
     */
    @ApiOperation(value = "获取菜单树列表", notes = "获取菜单树列表")
    @GetMapping("/selectMenuTreeList")
    public Result selectMenuTreeList() {
        return success(sysMenuService.selectMenuTreeList());
    }

    /**
     * 根据菜单ID查询信息
     */

    @ApiOperation(value = "根据菜单ID查询信息", notes = "根据菜单ID查询信息")
    @GetMapping(value = "/{menuId}")
    public Result selectMenuById(@PathVariable Long menuId) {
        return success(sysMenuService.selectMenuById(menuId));
    }

    /**
     * 根据用户ID查询菜单树信息（登录后调用，无需传参）
     */
    @ApiOperation(value = "根据用户ID查询菜单树信息（登录后调用，无需传参）", notes = "根据用户ID查询菜单树信息（登录后调用，无需传参）")
    @GetMapping("/selectMenuTreeByUserId")
    public Result selectMenuTreeByUserId() {
        // 取身份信息
        SysUser user = SecurityUtils.getUserInfo();
        // 根据用户id取出菜单
        return success(sysMenuService.selectMenuTreeByUserId(user.getUserId()));
    }
}
