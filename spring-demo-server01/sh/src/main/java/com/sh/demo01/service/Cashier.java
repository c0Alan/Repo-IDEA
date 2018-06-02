package com.sh.demo01.service;

import java.util.List;

public interface Cashier {

    /**
     * 一次购买多本书籍
     *
     * @param username
     * @param isbns
     */
    public void checkout(String username, List<String> isbns);

}
