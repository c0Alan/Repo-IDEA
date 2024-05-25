package com.demo.java.web.jdbc;

import com.demo.java.web.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 通过PreparedStatement对象完成对数据库的CRUD操作
 * PreperedStatement是Statement的子类，它的实例对象可以通过调用Connection.preparedStatement()方法获得，相对于Statement对象而言：PreperedStatement可以避免SQL注入的问题。
 * Statement会使数据库频繁编译SQL，可能造成数据库缓冲区溢出。PreparedStatement可对SQL进行预编译，从而提高数据库的执行效率。并且PreperedStatement对于sql中的参数，允许使用占位符的形式进行替换，简化sql语句的编写
 */
public class JdbcCRUDByPreparedStatement {

    @Test
    public void insert() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //获取一个数据库连接
            conn = JdbcUtils.getConnection();
            //要执行的SQL命令，SQL中的参数使用?作为占位符
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
            //通过conn对象获取负责执行SQL命令的prepareStatement对象
            st = conn.prepareStatement(sql);
            //为SQL语句中的参数赋值，注意，索引是从1开始的
            st.setInt(1, 5);//id是int类型的
            st.setString(2, "白虎神皇");//name是varchar(字符串类型)
            st.setString(3, "123");//password是varchar(字符串类型)
            st.setString(4, "bhsh@sina.com");//email是varchar(字符串类型)
            st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday是date类型
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
            String sql = "delete from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 5);
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
            String sql = "update users set name=?,email=? where id=?";
            st = conn.prepareStatement(sql);
            st.setString(1, "gacl");
            st.setString(2, "gacl@sina.com");
            st.setInt(3, 5);
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
            String sql = "select * from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 5);
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