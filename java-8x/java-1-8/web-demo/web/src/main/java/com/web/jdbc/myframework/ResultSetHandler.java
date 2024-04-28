package com.web.jdbc.myframework;

import java.sql.ResultSet;

/**
 * 结果集处理器接口
 * 
 * @author liuxilin
 * @date 2018/5/7 7:50
 */
public interface ResultSetHandler {
    
    /**
    * @Method: handler
    * @Description: 结果集处理方法
    * @Anthor:孤傲苍狼
    *
    * @param rs 查询结果集
    * @return
    */ 
    public Object handler(ResultSet rs);
}