package com.demo.java.web.jdbc;

import com.demo.java.web.jdbc.utils.JdbcUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 通过Statement对象完成对数据库的CRUD操作
 * 有sql注入的风险
 * 
 * @author liuxilin
 * @date 2018/5/15 23:05
 */
public class StatementDemo {
    private static final Logger logger = Logger.getLogger(StatementDemo.class);


    /**
     * 使用Statement实现JDBC批处理操作
     */
    @Test
    public void batchHandleByStatement() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into testbatch(id,name) values(1,'aaa')";
            String sql2 = "insert into testbatch(id,name) values(2,'bbb')";
            String sql3 = "insert into testbatch(id,name) values(3,'CCC')";
            String sql4 = "insert into testbatch(id,name) values(4,'DDD')";
            String sql5 = "update testbatch set name='abc' where id=1";
            String sql6 = "insert into testbatch(id,name) values(5,'FFF')";
            String sql7 = "delete from testbatch where id=2";
            st = conn.createStatement();
            //添加要批量执行的SQL
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.addBatch(sql3);
            st.addBatch(sql4);
            st.addBatch(sql5);
            st.addBatch(sql6);
            st.addBatch(sql7);
            //执行批处理SQL语句
            st.executeBatch();
            //清除批处理命令
            st.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void insertByStatement() {
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
    public void deleteByStatement() {
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
    public void updateByStatement() {
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
    public void findByStatement() {
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