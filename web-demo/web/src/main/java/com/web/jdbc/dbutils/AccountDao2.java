package com.web.jdbc.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import me.gacl.domain.Account;
import me.gacl.util.JdbcUtils;
import me.gacl.util.JdbcUtils2;

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
* @ClassName: AccountDao
* @Description: 针对Account对象的CRUD
* @author: 孤傲苍狼
* @date: 2014-10-6 下午4:00:42
*
*/ 
public class AccountDao2 {

    public void update(Account account) throws SQLException{
        
        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(),account.getMoney(),account.getId()};
        //JdbcUtils2.getConnection()获取当前线程中的Connection对象
        qr.update(JdbcUtils2.getConnection(),sql, params);
        
    }
    
    public Account find(int id) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //JdbcUtils2.getConnection()获取当前线程中的Connection对象
        return (Account) qr.query(JdbcUtils2.getConnection(),sql, id, new BeanHandler(Account.class));
    }
}