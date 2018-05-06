package com.web.jdbc.dbutils;

import java.sql.SQLException;
import me.gacl.dao.AccountDao3;
import me.gacl.domain.Account;

public class AccountService3 {
    
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
    public void transfer(int sourceid, int tartgetid, float money)
            throws SQLException {
        AccountDao3 dao = new AccountDao3();
        Account source = dao.find(sourceid);
        Account target = dao.find(tartgetid);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        dao.update(source);
        // 模拟程序出现异常让事务回滚
        int x = 1 / 0;
        dao.update(target);
    }
}