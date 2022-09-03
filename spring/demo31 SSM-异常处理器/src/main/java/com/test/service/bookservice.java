package com.test.service;
import com.test.dao.bookDao;
import com.test.domain.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class bookservice {
    @Autowired
    private bookDao bookDao;

    public boolean save(book book) {
        bookDao.save(book);
        return true;
    }

    public boolean update(book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<book> getAll() {
        return bookDao.getAll();
    }
}
