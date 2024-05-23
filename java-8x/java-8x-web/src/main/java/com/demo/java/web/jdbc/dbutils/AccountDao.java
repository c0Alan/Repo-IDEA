package com.demo.java.web.jdbc.dbutils;

import com.demo.java.web.domain.Account;
import com.demo.java.web.jdbc.util.JdbcUtils3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;


public class AccountDao {

    //接收service层传递过来的Connection对象
    private Connection conn = null;

    public AccountDao(Connection conn) {
        this.conn = conn;
    }

    public AccountDao() {

    }

    /**
     * 更新
     *
     * @param account
     * @throws SQLException
     */
    public void update(Account account) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(), account.getMoney(), account.getId()};
        //使用service层传递过来的Connection对象操作数据库
        qr.update(conn, sql, params);

    }

    /**
     * 查找
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Account find(int id) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //使用service层传递过来的Connection对象操作数据库
        return (Account) qr.query(conn, sql, new BeanHandler(Account.class), Integer.valueOf(id));
    }

    /**
     * 这个方法是用来处理两个用户之间的转账业务 在开发中，DAO层的职责应该只涉及到CRUD，
     * 而这个transfer方法是处理两个用户之间的转账业务的，已经涉及到具体的业务操作，应该在业务层中做，不应该出现在DAO层的
     * 所以在开发中DAO层出现这样的业务处理方法是完全错误的
     *
     * @param sourceName
     * @param targetName
     * @param money
     * @throws SQLException
     */
    public void transfer(String sourceName, String targetName, float money) throws SQLException {
        Connection conn = null;
        try {
            conn = JdbcUtils3.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            /**
             * 在创建QueryRunner对象时，不传递数据源给它，是为了保证这两条SQL在同一个事务中进行，
             * 我们手动获取数据库连接，然后让这两条SQL使用同一个数据库连接执行
             */
            QueryRunner runner = new QueryRunner();
            String sql1 = "update account set money=money-100 where name=?";
            String sql2 = "update account set money=money+100 where name=?";
            Object[] paramArr1 = {sourceName};
            Object[] paramArr2 = {targetName};
            runner.update(conn, sql1, paramArr1);
            //模拟程序出现异常让事务回滚
            int x = 1 / 0;
            runner.update(conn, sql2, paramArr2);
            //sql正常执行之后就提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                //出现异常之后就回滚事务
                conn.rollback();
            }
        } finally {
            //关闭数据库连接
            conn.close();
        }
    }
}