package com.demo.springcloud.service;

import com.demo.springcloud.enums.PublicEnum;
import com.demo.springcloud.entity.SysMenu;
import com.demo.springcloud.mapper.SysMenuMapper;
import com.demo.springcloud.mapper.SysRoleMenuMapper;
import com.demo.springcloud.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单 业务层
 *
 * @author li'chao
 */
@Slf4j
@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 新增保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu) {
        return sysMenuMapper.insert(menu);
    }

    /**
     * 修改保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu) {
        return sysMenuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Long menuId) {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public String checkMenuNameUnique(SysMenu menu) {
        String menuNmae = MyStringUtils.isNull(menu.getMenuName()) ? "" : menu.getMenuName();
        Long menuId = MyStringUtils.isNull(menu.getMenuId()) ? -1L : menu.getMenuId();
        SysMenu info = sysMenuMapper.checkMenuNameUnique(menuNmae);
        if (MyStringUtils.isNotNull(info) && info.getMenuId().longValue() != menuId.longValue()) {
            return PublicEnum.NOT_UNIQUE.getCode();
        }
        return PublicEnum.UNIQUE.getCode();

    }

    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysMenu selectMenuById(Long menuId) {
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    /**
     * 根据用户ID查询菜单树信息
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId) {
        List<SysMenu> allMenu = sysMenuMapper.selectMenusByUserId(userId);
        //根节点
        List<SysMenu> rootMenu = new ArrayList<SysMenu>();
        allMenu.forEach(nav -> {
            if (nav.getParentId() == 0) {//父节点是0的，为根节点。
                rootMenu.add(nav);
            }
        });
        //为根菜单设置子菜单，getClild是递归调用的
        rootMenu.forEach(nav -> {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<SysMenu> childList = getChild(String.valueOf(nav.getMenuId()), allMenu);
            nav.setChildren(childList);//给根节点设置子节点
        });
        /* 根据Menu类的order排序 */
        rootMenu.sort(Comparator.comparing(SysMenu::getOrderNum));
        return rootMenu;
    }

    /**
     * 菜单列表
     *
     * @return 菜单树表
     */
    public List<SysMenu> selectMenuList() {
        return sysMenuMapper.selectMenuList();
    }

    /**
     * 菜单树列表
     *
     * @return 菜单树列表
     */
    public List<SysMenu> selectMenuTreeList() {
        List<SysMenu> allMenu = sysMenuMapper.selectMenuList();
        //根节点
        List<SysMenu> rootMenu = new ArrayList<SysMenu>();
        allMenu.forEach(nav -> {
            if (nav.getParentId() == 0) {//父节点是0的，为根节点。
                rootMenu.add(nav);
            }
        });
        //为根菜单设置子菜单，getClild是递归调用的
        rootMenu.forEach(nav -> {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<SysMenu> childList = getChild(String.valueOf(nav.getMenuId()), allMenu);
            nav.setChildren(childList);//给根节点设置子节点
        });
        /* 根据Menu类的order排序 */
        rootMenu.sort(Comparator.comparing(SysMenu::getOrderNum));
        return rootMenu;
    }

    /**
     * 获取子节点
     *
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<SysMenu> getChild(String id, List<SysMenu> allMenu) {
        //子菜单
        List<SysMenu> childList = new ArrayList<SysMenu>();
        allMenu.forEach(nav -> {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (String.valueOf(nav.getParentId()).equals(id)) {
                childList.add(nav);
            }
        });
        //递归
        childList.forEach(nav -> {
            nav.setChildren(getChild(String.valueOf(nav.getMenuId()), allMenu));
        });
        childList.sort(Comparator.comparing(SysMenu::getOrderNum));//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<SysMenu>();
        }
        return childList;
    }

    /**
     * 是否存在菜单子节点
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public boolean hasChildByMenuId(Long menuId) {
        int result = sysMenuMapper.hasChildByMenuId(menuId);
        return result > 0 ? true : false;
    }

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public boolean checkMenuExistRole(Long menuId) {
        int result = sysRoleMenuMapper.checkMenuExistRole(menuId);
        return result > 0 ? true : false;
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(Long userId) {
        List<String> perms = sysMenuMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        perms.forEach(perm -> {
            if (MyStringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        });
        return permsSet;
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsListByUserId(Long userId) {
        return sysMenuMapper.selectPermsByUserId(userId);
    }
}
