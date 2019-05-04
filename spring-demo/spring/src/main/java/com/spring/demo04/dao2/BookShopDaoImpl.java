package com.spring.demo04.dao2;

import com.spring.demo04.dao.BookShopDao;
import com.sh.demo01.exceptions.BookStockException;
import com.sh.demo01.exceptions.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM springdemo.book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        //检查书的库存是否足够, 若不够, 则抛出异常
        String sql2 = "SELECT stock FROM springdemo.book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足!");
        }

        String sql = "UPDATE springdemo.book_stock SET stock = stock -1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    /**
     * 账户减去价格
     * @param username
     * @param price
     */
    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够, 若不足, 则抛出异常
        String sql2 = "SELECT balance FROM springdemo.account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if (balance < price) {
            throw new UserAccountException("余额不足!");
        }

        String sql = "UPDATE springdemo.account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql, price, username);
    }

}
