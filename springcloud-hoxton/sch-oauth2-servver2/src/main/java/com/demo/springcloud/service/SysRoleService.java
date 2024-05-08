package com.demo.springcloud.service;

import cn.hutool.core.util.ObjectUtil;
import com.demo.springcloud.entity.SysRole;
import com.demo.springcloud.entity.SysRoleMenu;
import com.demo.springcloud.enums.PublicEnum;
import com.demo.springcloud.mapper.SysRoleMapper;
import com.demo.springcloud.mapper.SysRoleMenuMapper;
import com.demo.springcloud.mapper.SysUserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 权限 业务层
 *
 * @author li'chao
 */
@Slf4j
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysUserRoleMapper sysyUserRoleMapper;

    /**
     * 新增保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    @Transactional
    public int insertRole(SysRole role) {
        // 新增角色信息
        sysRoleMapper.insert(role);
        return insertRoleMenu(role);
    }

    /**
     * 修改保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    @Transactional
    public int updateRole(SysRole role) {
        // 修改角色信息
        sysRoleMapper.updateByPrimaryKeySelective(role);
        // 删除角色与菜单关联
        sysRoleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
        return insertRoleMenu(role);
    }

    /**
     * 新增角色菜单信息
     *
     * @param role 角色对象
     */
    public int insertRoleMenu(SysRole role) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds()) {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0) {
            rows = sysRoleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }


    /**
     * 修改角色状态
     *
     * @param role 角色信息
     * @return 结果
     */
    public int updateRoleStatus(SysRole role) {
        return sysRoleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 批量删除角色信息
     *
     * @param roleIds 需要删除的角色ID
     * @return 结果
     */
    @Transactional
    public String deleteRoleByIds(Long[] roleIds) {
        StringBuilder failureMsg = new StringBuilder();  // 失败信息
        for (Long roleId : roleIds) {
            SysRole role = selectRoleById(roleId);
            if (countUserRoleByRoleId(roleId) > 0) {
                log.error("不能删除,[{}]已分配", role.getRoleName());
                failureMsg.append("不能删除,[" + role.getRoleName() + "]已分配");

            } else {
                sysRoleMapper.deleteByPrimaryKey(roleId);
                failureMsg.append("删除成功");
            }
        }
        return failureMsg.toString();
    }

    /**
     * 通过角色ID查询角色
     *
     * @param roleId 角色ID
     * @return 角色对象信息
     */
    public SysRole selectRoleById(Long roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 通过角色ID查询角色使用数量
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId) {
        return sysyUserRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * 校验角色名称是否唯一
     *
     * @param role 角色信息
     * @return 结果
     */
    public String checkRoleNameUnique(SysRole role) {
        Long roleId = ObjectUtil.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleNameUnique(role.getRoleName());
        if (ObjectUtil.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()) {
            return PublicEnum.NOT_UNIQUE.getCode();
        }
        return PublicEnum.UNIQUE.getCode();
    }

    /**
     * 查询所有角色
     *
     * @return 角色列表
     */
    public List<SysRole> selectRoleAll() {
        List<SysRole> list = sysRoleMapper.selectRoleAll();
        list.forEach(sysRole -> {
            if (ObjectUtil.isNotNull(sysRole)) {
                Long[] menuIds = sysRoleMenuMapper.selectMenuIdsByRoleId(sysRole.getRoleId());
                sysRole.setMenuIds(menuIds);
            }
        });
        return list;
    }

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(Long userId) {
        List<SysRole> perms = sysRoleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        perms.forEach(perm -> {
            if (ObjectUtil.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        });
        return permsSet;
    }

}
