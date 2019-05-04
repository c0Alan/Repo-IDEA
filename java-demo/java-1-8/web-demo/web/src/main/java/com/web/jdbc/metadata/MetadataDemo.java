package com.web.jdbc.metadata;

import com.web.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.*;

/**
 * 元数据测试
 * 
 * @author liuxl
 * @date 2018/5/16 12:54
 */
public class MetadataDemo {

    /**
     * 获取数据库的元信息
     * @throws SQLException
     */
    @Test
    public void testDataBaseMetaData() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        DatabaseMetaData metadata = conn.getMetaData();
        //getURL()：返回一个String类对象，代表数据库的URL
        System.out.println(metadata.getURL());
        //getUserName()：返回连接当前数据库管理系统的用户名
        System.out.println(metadata.getUserName());
        //getDatabaseProductName()：返回数据库的产品名称
        System.out.println(metadata.getDatabaseProductName());
        //getDatabaseProductVersion()：返回数据库的版本号
        System.out.println(metadata.getDatabaseProductVersion());
        //getDriverName()：返回驱动驱动程序的名称
        System.out.println(metadata.getDriverName());
        //getDriverVersion()：返回驱动程序的版本号
        System.out.println(metadata.getDriverVersion());
        //isReadOnly()：返回一个boolean值，指示数据库是否只允许读操作
        System.out.println(metadata.isReadOnly());
        JdbcUtils.release(conn, null, null);
    }

    /**
     * 获取参数元信息
     * @throws SQLException
     */
    @Test
    public void testParameterMetaData() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String sql = "select * from springdemo.users where name=? and password=?";
        //将SQL预编译一下
        PreparedStatement st = conn.prepareStatement(sql);
        ParameterMetaData pm = st.getParameterMetaData();
        //getParameterCount() 获得指定参数的个数
        System.out.println(pm.getParameterCount());
        //getParameterType(int param)：获得指定参数的sql类型，MySQL数据库驱动不支持
        System.out.println(pm.getParameterType(1));
        JdbcUtils.release(conn, null, null);
    }

    /**
     * 结果集的元数据
     * @throws Exception
     */
    @Test
    public void testResultSetMetaData() throws Exception {
        Connection conn = JdbcUtils.getConnection();
        String sql = "select * from springdemo.account";
        PreparedStatement st  = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        //ResultSet.getMetaData()获得代表ResultSet对象元数据的ResultSetMetaData对象
        ResultSetMetaData metadata = rs.getMetaData();
        //getColumnCount() 返回resultset对象的列数
        System.out.println(metadata.getColumnCount());
        //getColumnName(int column) 获得指定列的名称
        System.out.println(metadata.getColumnName(1));
        //getColumnTypeName(int column)获得指定列的类型
        System.out.println(metadata.getColumnTypeName(1));
        JdbcUtils.release(conn, st, rs);
    }
    
}
