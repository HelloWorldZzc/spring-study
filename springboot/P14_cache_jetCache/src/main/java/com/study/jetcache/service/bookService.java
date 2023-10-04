package com.study.jetcache.service;


import com.alicp.jetcache.anno.*;
import com.study.jetcache.mapper.bookMapper;
import com.study.jetcache.pojo.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @CacheUpdate(name = "bookCache_",key = "#book.id",value = "#book")
    public book modify(book book) {
        return mapper.updateById(book)>0 ? mapper.selectById(book.getId()):null;
    }

    //删
    @CacheInvalidate(name = "bookCache_",key = "#id")
    public boolean delete(Integer id) {
        return mapper.deleteById(id)>0;
    }

    //查询所有
    public List<book> getAll() {
        return mapper.selectList(null);
    }
    //根据id查
    @Cached(name = "bookCache_",key = "#id",expire = 20,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 100,timeUnit = TimeUnit.SECONDS)
    public book getById(int id){
        return mapper.selectById(id);
    }
}
