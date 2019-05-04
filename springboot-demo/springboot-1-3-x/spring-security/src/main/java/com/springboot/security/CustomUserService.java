package com.springboot.security;

import com.springboot.dao.SysUserRepository;
import com.springboot.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义用户细节信息Service, 返回UserDetails实现实体类给Spring Security 使用
 * 
 * @author liuxilin
 * @date 2018/6/14 23:38
 */
public class CustomUserService implements UserDetailsService { 
    @Autowired
    SysUserRepository userRepository;

    /**
     * 重写loadUserByUsemame 方法获得用户。
     * 我们当前的用户实现了UserDetails 接口，可直接返回给Spring Security 使用。
     *
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return user; 
    }

}
