package com.demo.java.web.jdbc.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: JdbcUtils_DBCP
 * @Description: 数据库连接工具类
 * @author: 孤傲苍狼
 * @date: 2014-10-4 下午6:04:36
 */
public class JdbcUtils_JNDI {

    private static DataSource ds = null;

    //在静态代码块中创建数据库连接池
    static {
        try {
            //初始化JNDI
            Context initCtx = new InitialContext();
            //得到JNDI容器
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            //从JNDI容器中检索name为jdbc/datasource的数据源
            ds = (DataSource) envCtx.lookup("jdbc/datasource");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * @return Connection
     * @throws SQLException
     * @Method: getConnection
     * @Description: 从数据源中获取数据库连接
     * @Anthor:孤傲苍狼
     */
    public static Connection getConnection() throws SQLException {
        //从数据源中获取数据库连接
        return ds.getConnection();
    }

    /**
     * @param conn
     * @param st
     * @param rs
     * @Method: release
     * @Description: 释放资源，
     * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
     * @Anthor:孤傲苍狼
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                //关闭存储查询结果的ResultSet对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                //关闭负责执行SQL命令的Statement对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                //将Connection连接对象还给数据库连接池
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}