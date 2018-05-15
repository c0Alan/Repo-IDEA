package com.web.jdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.web.jdbc.util.JdbcUtils;
import org.junit.Test;

/**
 * 通过PreparedStatement对象完成对数据库的CRUD操作
 *
 * @author liuxilin
 * @date 2018/5/15 23:57
 */
public class PreparedStatementDemo {

    @Test
    public void insert() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //获取一个数据库连接
            conn = JdbcUtils.getConnection();
            //要执行的SQL命令，SQL中的参数使用?作为占位符
            String sql = "insert into springdemo.users(id,name,password,email,birthday)" +
                    " values(?,?,?,?,?)";
            //通过conn对象获取负责执行SQL命令的prepareStatement对象
            st = conn.prepareStatement(sql);
            //为SQL语句中的参数赋值，注意，索引是从1开始的

            st.setInt(1, 3); //id是int类型的
            st.setString(2, "吴承恩"); //name是varchar(字符串类型)
            st.setString(3, "123"); //password是varchar(字符串类型)
            st.setString(4, "wce@sina.com"); //email是varchar(字符串类型)
            st.setDate(5, new java.sql.Date(new Date().getTime())); //birthday是date类型
            //执行插入操作，executeUpdate方法返回成功的条数
            int num = st.executeUpdate();
            if (num > 0) {
                System.out.println("插入成功！！");
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from springdemo.users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 3);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update springdemo.users set name=?,email=? where id=?";
            st = conn.prepareStatement(sql);
            st.setString(1, "辛弃疾");
            st.setString(2, "xqj@sina.com");
            st.setInt(3, 1);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from springdemo.users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            rs = st.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}