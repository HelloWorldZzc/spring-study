package com.study.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class bookServer {
    @Autowired
    private bookDao bookDao;
    @Transactional
    public void buyBook(Integer bookId, Integer userID) {
        //查询图书的价格
        Integer price  = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userID,price);

    }
}
