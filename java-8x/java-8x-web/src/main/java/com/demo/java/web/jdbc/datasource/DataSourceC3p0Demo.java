package com.demo.java.web.jdbc.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.java.web.jdbc.util.JdbcUtils_C3P0;
import org.junit.Test;

public class DataSourceC3p0Demo {
    
    @Test
    public void c3p0DataSourceTest() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = JdbcUtils_C3P0.getConnection();
            String sql = "insert into springdemo.test1(name) values(?)";
            st = conn.prepareStatement(sql);
            st.setString(1, "小桃红");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtils_C3P0.release(conn, st, rs);
        }
    }
}