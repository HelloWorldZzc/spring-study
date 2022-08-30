package com.test.service.impl;

import com.test.dao.AccountDao;
import com.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(String out,String in ,Double money) {
        accountDao.outMoney(out,money);
//        int i = 1/0;
        accountDao.inMoney(in,money);
    }

}
