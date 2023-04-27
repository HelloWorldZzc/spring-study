package com.study.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.demo.pojo.book;
import com.study.demo.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    private bookService bookSer;

    //增删改查所调用的相关逻辑
    @GetMapping("/")
    public List<book> getAll(){
        return bookSer.list();
    }

    @PostMapping("/")
    public String save(@RequestBody book book){
        boolean save = bookSer.save(book);
        return save ? "ok" : "error";
    }

    @PutMapping("/")
    public String update(@RequestBody book book){
        boolean modify = bookSer.modify(book);
        return modify ? "ok" :"error";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){
        boolean delete = bookSer.delete(id);
        return delete ? "ok" : "error";

    }
    @GetMapping("{id}")
    public book getById(@PathVariable Integer id){
        return bookSer.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<book> getPage(@PathVariable int currentPage, @PathVariable int pageSize, book book){
        //获取当前的页码信息
        IPage<book> page = bookSer.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()) {
            bookSer.getPage((int)page.getPages(),pageSize,book);
        }
        return page;
    }

}
