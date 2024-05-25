package com.demo.java.web.jdbc;

import com.demo.java.web.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 通过PreparedStatement对象完成对数据库的CRUD操作
 * PreperedStatement是Statement的子类，它的实例对象可以通过调用Connection.preparedStatement()方法获得，相对于Statement对象而言：PreperedStatement可以避免SQL注入的问题。
 * Statement会使数据库频繁编译SQL，可能造成数据库缓冲区溢出。PreparedStatement可对SQL进行预编译，从而提高数据库的执行效率。
 * 并且PreperedStatement对于sql中的参数，允许使用占位符的形式进行替换，简化sql语句的编写
 *
 * @author liuxilin
 * @date 2018/5/15 23:57
 */
public class PreparedStatementDemo {


    /**
     * 使用prepareStatement实现JDBC批处理操作
     * 优点：发送的是预编译后的SQL语句，执行效率高。
     * 缺点：只能应用在SQL语句相同，但参数不同的批处理中。
     * 因此此种形式的批处理经常用于在同一个表中批量插入数据，或批量更新表的数据。
     */
    @Test
    public void batchHandleByPrepareStatement() {
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into testbatch(id,name) values(?,?)";
            st = conn.prepareStatement(sql);
            for (int i = 6; i < 10008; i++) {  //i=1000  2000
                st.setInt(1, i);
                st.setString(2, "aa" + i);
                st.addBatch();
                if (i % 1000 == 0) {
                    st.executeBatch();
                    st.clearBatch();
                }
            }
            st.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime - starttime) / 1000 + "秒！！"); // 4s
    }

    @Test
    public void insertByPrepareStatement() {
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
    public void deleteByPrepareStatement() {
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
    public void updateByPrepareStatement() {
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
    public void findByPrepareStatement() {
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