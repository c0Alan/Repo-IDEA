package com.demo.springcloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
 * @createDate 2024-09-07 22:07:22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public SysUser getByUserCode(String usercode) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usercode", usercode);
        return this.getOne(queryWrapper);
    }

    public List<SysUser> getListByUsername(String username) {
        return baseMapper.selectListByUsername(username);
    }

    public boolean saveEncrypt(SysUser sysUser) {
        if (StrUtil.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        }
        return save(sysUser);
    }


}




