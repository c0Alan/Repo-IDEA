package com.demo.springcloud.security;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.service.impl.SysUserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * security 的 UserDetailsService
 *
 * @author liuxl
 * @date 2024/9/17
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private SysUserServiceImpl sysUserService;


    @Override
    public UserDetails loadUserByUsername(String usercode) throws UsernameNotFoundException {
        /**
         * 1/通过userName 获取到userInfo信息
         * 2/通过User（UserDetails）返回details。
         */
        //通过userName获取用户信息
        SysUser sysUser = sysUserService.getByUserCode(usercode);
        if (sysUser == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String roleId : sysUser.getRoleIds().split(",")){
            // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleId));
        }
        User userDetails = new User(sysUser.getUsercode(), sysUser.getPassword(), authorities);
        return userDetails;
    }
}