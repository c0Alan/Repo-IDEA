package com.spring.demo04.service;

public interface BookShopService {

    /**
     * 根据书号购买书籍
     * @param username
     * @param isbn
     */
    public void purchase(String username, String isbn);

}
