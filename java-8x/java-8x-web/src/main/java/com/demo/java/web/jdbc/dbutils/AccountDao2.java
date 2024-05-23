package com.demo.java.web.jdbc.dbutils;

import java.sql.SQLException;

import com.demo.java.web.domain.Account;
import com.demo.java.web.jdbc.util.JdbcUtils3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/*
create table account(
    id int primary key auto_increment,
    name varchar(40),
    money float
)character set utf8 collate utf8_general_ci;

insert into account(name,money) values('A',1000);
insert into account(name,money) values('B',1000);
insert into account(name,money) values('C',1000);

*/

/**
 * 针对Account对象的CRUD
 *
 * @author liuxilin
 * @date 2018/5/16 22:30
 */
public class AccountDao2 {

    public void update(Account account) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(), account.getMoney(), account.getId()};
        //JdbcUtils3.getConnection()获取当前线程中的Connection对象
        qr.update(JdbcUtils3.getConnection(), sql, params);

    }

    public Account find(int id) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //JdbcUtils3.getConnection()获取当前线程中的Connection对象
        return (Account) qr.query(JdbcUtils3.getConnection(), sql, id, new BeanHandler(Account.class));
    }
}