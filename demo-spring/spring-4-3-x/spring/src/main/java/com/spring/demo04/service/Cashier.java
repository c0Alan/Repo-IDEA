package com.spring.demo04.service;

import java.util.List;

public interface Cashier {

    /**
     * 根据书号列表购买多本书
     * @param username
     * @param isbns
     */
    public void checkout(String username, List<String> isbns);

}
