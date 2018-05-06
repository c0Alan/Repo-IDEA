package com.web.jdbc.dbutils;

import java.sql.SQLException;
import me.gacl.dao.AccountDao2;
import me.gacl.domain.Account;
import me.gacl.util.JdbcUtils2;

public class AccountService2 {
    
    /**
    * @Method: transfer
    * @Description:在业务层处理两个账户之间的转账问题
    * @Anthor:孤傲苍狼
    *
    * @param sourceid
    * @param tartgetid
    * @param money
    * @throws SQLException
    */ 
    public void transfer(int sourceid,int tartgetid,float money) throws SQLException{
        try{
            //开启事务，在业务层处理事务，保证dao层的多个操作在同一个事务中进行
            JdbcUtils2.startTransaction();
            AccountDao2 dao = new AccountDao2();
            
            Account source = dao.find(sourceid);
            Account target = dao.find(tartgetid);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            
            dao.update(source);
            //模拟程序出现异常让事务回滚
            int x = 1/0;
            dao.update(target);
            
            //SQL正常执行之后提交事务
            JdbcUtils2.commit();
        }catch (Exception e) {
            e.printStackTrace();
            //出现异常之后就回滚事务
            JdbcUtils2.rollback();
        }finally{
            //关闭数据库连接
            JdbcUtils2.close();
        }
    }
}