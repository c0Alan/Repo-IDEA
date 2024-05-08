package com.demo.springcloud.service;

import com.demo.springcloud.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录 业务层
 *
 * @author li'chao
 */
@Slf4j
@Component
public class SysLoginService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // 根据登录名称查询用户信息
        SysUser sysUser = sysUserService.selectUserByLoginName(name);
        if (null == sysUser) {
            log.warn("用户{}不存在", name);
            throw new UsernameNotFoundException(name);
        }
        // 根据用户ID查询权限配置的菜单，获取菜单标识字段perms
        List<String> permsList = sysMenuService.selectPermsListByUserId(sysUser.getUserId());
        permsList.remove(null);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(permsList)) {
            for (String str : permsList) {
                authorityList.add(new SimpleGrantedAuthority(str));
            }
        }

        return new User(sysUser.getLoginName(), passwordEncoder.encode(sysUser.getPassword()), authorityList);
    }
}
