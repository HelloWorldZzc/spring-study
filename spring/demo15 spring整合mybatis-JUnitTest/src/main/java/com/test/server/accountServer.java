package com.test.server;

import com.test.dao.accountDao;
import com.test.domain.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountServer {
    @Autowired
    private accountDao accountDao;

    public void save(account account) {
        accountDao.save(account);
    }

    public void update(account account){
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public account findById(Integer id) {
        return accountDao.findById(id);
    }

    public List<account> findAll() {
        return accountDao.findAll();
    }
}
