package com.web.jdbc.dbutils;

import java.sql.Date;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialClob;

import com.web.domain.Users;
import com.web.jdbc.util.JdbcUtils3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 使用dbutils框架的QueryRunner类完成CRUD,以及批处理
 * 
 * @author liuxilin
 * @date 2018/5/7 7:56
 */
public class QueryRunnerCRUDTest {
    private static final Logger logger = Logger.getLogger(QueryRunnerCRUDTest.class);
    
    @Test
    public void add() throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "insert into springdemo.users(name, password, email, birthday) values(?,?,?,?)";
//        Object params[] = {"白居易","123", "bjy@sina.com", new Date(System.currentTimeMillis())};
        Object params[] = {"李白","123", "lb@sina.com", Date.valueOf("1990-05-07")};

        qr.update(sql, params);
    }
    
    @Test
    public void delete() throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "delete from springdemo.users where id=?";
        qr.update(sql, 1);

    }

    @Test
    public void update() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "update springdemo.users set name=? where id=?";
        Object params[] = { "李清照", 2};
        qr.update(sql, params);
    }

    @Test
    public void find() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users where id=?";
        Object params[] = {2};
        Users user = (Users) qr.query(sql, new BeanHandler(Users.class), params);
        logger.info("生日: " + user.getBirthday()); // 显示红色字体
    }

    @Test
    public void getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "select * from springdemo.users";
        List list = (List) qr.query(sql, new BeanListHandler(Users.class));
        System.out.println(list.size());
    }

    /**
     * 批处理
     * @throws SQLException
     */
    @Test
    public void testBatch() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "insert into springdemo.users(name,password,email,birthday) values(?,?,?,?)";
        Object params[][] = new Object[10][];
        for (int i = 0; i < 10; i++) {
            params[i] = new Object[] { "aa" + i, "123", "aa@sina.com",
                    new Date(System.currentTimeMillis()) };
        }
        qr.batch(sql, params);
    }
    
    //用dbutils完成大数据（不建议用）
    @Test
    public void testclob() throws SQLException, IOException{
        QueryRunner runner = new QueryRunner(JdbcUtils3.getDataSource());
        String sql = "insert into springdemo.testclob(resume) values(?)";  //clob
        //这种方式获取的路径，其中的空格会被使用“%20”代替
        String path  = QueryRunnerCRUDTest.class.getClassLoader().getResource("data.txt").getPath();
        //将“%20”替换回空格
        path = path.replaceAll("%20", " ");
        FileReader in = new FileReader(path);
        char[] buffer = new char[(int) new File(path).length()];
        in.read(buffer);
        SerialClob clob = new SerialClob(buffer);
        Object params[] = {clob};
        runner.update(sql, params);
    }
}