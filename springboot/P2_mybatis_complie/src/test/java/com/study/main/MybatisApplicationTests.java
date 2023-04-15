package com.study.main;

import com.study.main.mapper.bookMapper;
import com.study.main.pojo.book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private bookMapper book;

    @Test
    public void test1(){
        List<book> books = book.selectAll();
        books.forEach(System.out::println);

    }

    @Test
    public void test2(){
        System.out.println(book.selectById(1));
    }

}
