package com.test.service;


import com.test.config.springConfig;
import com.test.domain.book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class bookServiceTest {

    @Autowired
    private bookservice bookService;

    @Test
    public void testGetById(){
        book book = bookService.getById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<book> all = bookService.getAll();
        System.out.println(all);
    }

}
