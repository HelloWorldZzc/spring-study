package com.study.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.demo.pojo.book;


// 服务层 接口类 继承MP的相关接口，同时添加相关接口
public interface bookService extends IService<book> {
    boolean saveBook(book book);

    boolean modify(book book);

    boolean delete(Integer id);

    IPage<book> getPage(int currentPage, int pageSize);

    IPage<book> getPage(int currentPage, int pageSize, book book);
}
