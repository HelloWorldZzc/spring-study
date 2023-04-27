package com.study.demo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.demo.mapper.bookMapper;
import com.study.demo.pojo.book;
import com.study.demo.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class bookServiceImp extends ServiceImpl<bookMapper, book> implements bookService  {

    @Autowired
    private bookMapper bookMapper;


    @Override
    //增
    public boolean saveBook(book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
    //改
    public boolean modify(book book) {
        return bookMapper.updateById(book)>0;
    }

    @Override
    //删
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    //分页查询所有
    public IPage<book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookMapper.selectPage(page,null);
        return page;
    }

    @Override
    //分页查询
    public IPage<book> getPage(int currentPage, int pageSize, book book) {
        //创建查询条件
        LambdaQueryWrapper<book> lqw = new LambdaQueryWrapper<>();
        //参数一：判断时候存在  参数二：数据库中对应的名 参数三：相关的数据
        lqw.like(StringUtils.isNotBlank(book.getType()), com.study.demo.pojo.book::getType,book.getType());
        lqw.like(StringUtils.isNotBlank(book.getName()), com.study.demo.pojo.book::getName,book.getName());
        lqw.like(StringUtils.isNotBlank(book.getDescription()),com.study.demo.pojo.book::getDescription,book.getDescription());

        //开启分页查询
        Page page = new Page(currentPage,pageSize);
        bookMapper.selectPage(page,lqw);
        return page;
    }
}
