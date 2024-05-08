package com.demo.springcloud.mapper;

/**
 * 菜单 数据层
 * lc
 */


import com.demo.springcloud.entity.SysMenu;
import com.demo.springcloud.entity.SysMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {

    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    SysMenu checkMenuNameUnique(String menuName);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectMenuList();

    List<SysMenu> selectMenusByUserId(Long userId);

    int hasChildByMenuId(Long menuId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);
}