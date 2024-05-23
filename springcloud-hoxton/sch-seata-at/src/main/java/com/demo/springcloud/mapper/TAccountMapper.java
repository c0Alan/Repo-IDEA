package com.demo.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.springcloud.entity.TAccount;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 账户表 Mapper 接口
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
public interface TAccountMapper extends BaseMapper<TAccount> {

    @Update("update t_account set money = money + #{money} where user_id = #{userId}")
    void addMoney(String userId, int money);

}
