package com.demo.java.web.jdbc.dbutils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.demo.java.web.jdbc.util.JdbcUtils3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 测试dbutils各种类型的处理器
 *
 * @author liuxilin
 * @date 2018/5/16 20:54
 */
public class ResultSetHandlerTest {
    private static final Logger logger = Logger.getLogger(ResultSetHandlerTest.class);

    /**
     * 以Array的方式返回第一条记录
     * @throws SQLException
     */
    @Test
    public void testArrayHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";
        Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
       logger.info(Arrays.asList(result));  // [2, 李清照, 123, bjy@sina.com, 2018-05-16]
    }

    /**
     * 以ArrayList的方式返回所有记录列表
     * @throws SQLException
     */
    @Test
    public void testArrayListHandler() throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";
        List<Object[]> list = (List) qr.query(sql, new ArrayListHandler());

//        [2, 李清照, 123, bjy@sina.com, 2018-05-16]
//        [3, aa0, 123, aa@sina.com, 2018-05-16]
        for (Object[] o : list) {
            System.err.println(Arrays.asList(o));
        }
    }

    /**
     * List 方式获取某一列的列表
     * @throws SQLException
     */
    @Test
    public void testColumnListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";
        List list = (List) qr.query(sql, new ColumnListHandler("id"));
        logger.error(list); // [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
    }

    /**
     * 以 MapMap 的方式获取所有记录
     * @throws Exception
     */
    @Test
    public void testKeyedHandler() throws Exception {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";

        Map<Integer, Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
        for (Map.Entry<Integer, Map> me : map.entrySet()) {
            int id = me.getKey();
            Map<String, Object> innermap = me.getValue();
            for (Map.Entry<String, Object> innerme : innermap.entrySet()) {
                String columnName = innerme.getKey();
                Object value = innerme.getValue();
                System.err.println(columnName + "=" + value);
            }
            System.out.println("----------------");
        }
    }

    /**
     * 以map的方式获取第一条记录
     * @throws SQLException
     */
    @Test
    public void testMapHandler() throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";

        Map<String, Object> map = (Map) qr.query(sql, new MapHandler());
        for (Map.Entry<String, Object> me : map.entrySet()) {
            System.err.println(me.getKey() + "=" + me.getValue());
        }
    }


    /**
     * listMap 方式获取 所有记录
     * @throws SQLException
     */
    @Test
    public void testMapListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";
        List<Map> list = (List) qr.query(sql, new MapListHandler());
        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> me : map.entrySet()) {
                System.out.println(me.getKey() + "=" + me.getValue());
            }
        }
    }

    /**
     * 获取记录数
     * @throws SQLException
     */
    @Test
    public void testScalarHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select count(*) from springdemo.users";  //[13]  list[13]
        int count = ((Long) qr.query(sql, new ScalarHandler(1))).intValue();
        System.out.println(count);
    }
}