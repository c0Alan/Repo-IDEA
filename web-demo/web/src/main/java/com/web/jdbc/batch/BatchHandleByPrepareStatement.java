package com.web.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.web.jdbc.util.JdbcUtils;
import org.junit.Test;

/**
 * 使用prepareStatement实现JDBC批处理操作
 * <p>
 * 优点：发送的是预编译后的SQL语句，执行效率高。
 * 缺点：只能应用在SQL语句相同，但参数不同的批处理中。
 * 因此此种形式的批处理经常用于在同一个表中批量插入数据，或批量更新表的数据。
 *
 * @author liuxilin
 * @date 2018/5/5 14:52
 */
public class BatchHandleByPrepareStatement {

    @Test
    public void testJdbcBatchHandleByPrepareStatement() {
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into springdemo.testbatch(id,name) values(?,?)";
            st = conn.prepareStatement(sql);
            for (int i = 6; i < 100008; i++) {  //i=1000  2000
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
        System.out.println("程序花费时间：" + (endtime - starttime) / 1000 + "秒！！");
    }
}