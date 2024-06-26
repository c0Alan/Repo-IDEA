package com.demo.java.web.jdbc.dbutils;

import java.sql.SQLException;

import com.demo.java.web.domain.Account;
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
 * @date 2018/5/16 22:28
 */
public class AccountDao3 {

    public void update(Account account) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(), account.getMoney(), account.getId()};
        //ConnectionContext.getInstance().getConnection()获取当前线程中的Connection对象
        qr.update(ConnectionContext.getInstance().getConnection(), sql, params);

    }

    public Account find(int id) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //ConnectionContext.getInstance().getConnection()获取当前线程中的Connection对象
        return (Account) qr.query(ConnectionContext.getInstance().getConnection(), sql, new BeanHandler(Account.class), id);
    }
}