package com.web.jdbc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.web.jdbc.util.JdbcUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 通过Statement对象完成对数据库的CRUD操作
 * 有sql注入的风险
 * 
 * @author liuxilin
 * @date 2018/5/15 23:05
 */
public class StatementDemo {
    private static final Logger logger = Logger.getLogger(StatementDemo.class);

    @Test
    public void insert() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取一个数据库连接
            conn = JdbcUtils.getConnection();
            //通过conn对象获取负责执行SQL命令的Statement对象
            st = conn.createStatement();
            //要执行的SQL命令
            String sql = "insert into springdemo.users(id, name, password, email, birthday)" +
                    " values(2,'张君宝','123','bhsh@sina.com','1990-09-09')";
            //执行插入操作，executeUpdate方法返回成功的条数
            int num = st.executeUpdate(sql);
            if (num > 0) {
                logger.info("插入成功！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //SQL执行完成之后释放相关资源
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void delete() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from springdemo.users where id = 3";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void update() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update springdemo.users set name='白居易',email='bjy@sina.com' where id = 2";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("更新成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void find() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from springdemo.users where id = 2";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
               logger.info(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}