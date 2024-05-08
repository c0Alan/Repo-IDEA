package com.demo.springcloud.service;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.entity.SysUserRole;
import com.demo.springcloud.enums.PublicEnum;
import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.mapper.SysUserRoleMapper;
import com.demo.springcloud.utils.SecurityUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息 业务层
 *
 * @author li'chao
 */
@Slf4j
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Transactional
    public int insertUser(SysUser user) {
        // 密码加密
        String salt = String.valueOf((Math.random() * 900) + 100);
        user.setSalt(salt);
        String password = SecurityUtils.encryptPassword(user.getPassword());
        user.setPassword(password);
        // 新增用户信息
        int rows = sysUserMapper.insert(user);
        // 新增用户与角色管理
        for (Long roleId : user.getRoleIds()) {
            SysUserRole userRole = new SysUserRole();
            // 用户ID
            userRole.setUserId(user.getUserId());
            // 权限ID
            userRole.setRoleId(roleId);
            sysUserRoleMapper.insert(userRole);
        }
        return rows;
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Transactional
    public int updateUser(SysUser user) {
        Long userId = user.getUserId();
        // 删除用户与角色关联
        for (Long roleId : user.getRoleIds()) {

            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            sysUserRoleMapper.deleteByPrimaryKey(userRole);
        }
        // 新增用户与角色管理
        for (Long roleId : user.getRoleIds()) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            sysUserRoleMapper.insert(userRole);
        }
        // 修改用户信息
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateByPrimaryKeySelective(SysUser user) {
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }


    /**
     * 修改用户状态
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserStatus(SysUser user) {
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 重置用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    public String resetUserPwd(SysUser user) {
        String result = null;
        // 密码加密
        String salt = String.valueOf((Math.random() * 900) + 100);
        user.setSalt(salt);
        if (StrUtil.isNotEmpty(user.getPassword())) {
            String password = SecurityUtils.encryptPassword(user.getPassword());
            user.setPassword(password);
        } else {
            String password = SecurityUtils.encryptPassword("123456");
            user.setPassword(password);
            result = "123456";
        }
        sysUserMapper.updateByPrimaryKeySelective(user);
        return result;
    }

    /**
     * 根据ID修改用户密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public String updateUserPwd(Long userId, String oldPassword, String newPassword) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        String selectPassword = SecurityUtils.encryptPassword(oldPassword);
        if (!user.getPassword().equals(selectPassword)) {
            return "旧密码输入不正确";
        } else {
            // 密码加密
            String salt = String.valueOf((Math.random() * 900) + 100);
            user.setSalt(salt);
            String password = SecurityUtils.encryptPassword(newPassword);
            user.setPassword(password);
            sysUserMapper.updateByPrimaryKey(user);
            return "修改成功";
        }
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Transactional
    public int deleteUserById(Long userId) {
        // 删除用户与角色关联
        sysUserRoleMapper.deleteUserById(userId);
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 校验登录名是否唯一
     *
     * @param user 用户信息
     * @return
     */
    public String checkLoginNameUnique(SysUser user) {
        Long userId = ObjectUtil.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = sysUserMapper.checkLoginNameUnique(user.getLoginName());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return PublicEnum.NOT_UNIQUE.getCode();
        }
        return PublicEnum.UNIQUE.getCode();
    }

    /**
     * 根据登录名称查询用户信息
     *
     * @param LoginName 登录名称
     * @return
     */
    public SysUser selectUserByLoginName(String LoginName) {
        return sysUserMapper.checkLoginNameUnique(LoginName);
    }

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public PageInfo selectUserList(SysUser user, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserMapper.selectUserList(user);
        list.forEach(sysUser -> {
            sysUser.setRoleIds(sysUserRoleMapper.selectRoleIdByUserId(sysUser.getUserId()));
            sysUser.setRoleName(sysUserRoleMapper.selectRoleNameByUserId(sysUser.getUserId()));
        });
        PageInfo info = new PageInfo(list);
        return info;
    }

    /**
     * 根据用户ID获取详细信息
     *
     * @param userId
     * @return
     */
    public SysUser selectUserByUserId(Long userId) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        sysUser.setRoleIds(sysUserRoleMapper.selectRoleIdByUserId(userId));
        sysUser.setRoleName(sysUserRoleMapper.selectRoleNameByUserId(userId));
        return sysUser;
    }
}
