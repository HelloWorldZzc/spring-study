package com.study.ehcache.service;

import com.study.ehcache.mapper.bookMapper;
import com.study.ehcache.pojo.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {

    @Autowired
    public bookMapper mapper;

    @Autowired
    public bookMapper mapper1;


    //增
    public boolean saveBook(book book) {
        return mapper.insert(book)>0;
    }

    //改
    @CachePut(value = "book_id",key = "#book.id")
    public book modify(book book) {
        return mapper.updateById(book)>0 ? mapper.selectById(book.getId()):null;
    }

    //删
    public boolean delete(Integer id) {
        return mapper.deleteById(id)>0;
    }

    //查询所有
    public List<book> getAll() {
        return mapper.selectList(null);
    }
    //根据id查
    @Cacheable(value = "book_id",key = "#id")
    public book getById(int id){
        return mapper.selectById(id);
    }
}
