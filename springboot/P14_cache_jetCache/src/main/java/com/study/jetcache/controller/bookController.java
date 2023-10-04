package com.study.jetcache.controller;


import com.study.jetcache.pojo.book;
import com.study.jetcache.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {
    @Autowired
    private bookService bookSer;

    @GetMapping("/")
    public List<book> getAll(){
        return bookSer.getAll();
    }

    @PostMapping("/")
    public String save(@RequestBody book book){
        boolean save = bookSer.saveBook(book);
        return save ? "ok" : "error";
    }

    @PutMapping("/")
    public book update(@RequestBody book book){
        System.out.println(book);
        return bookSer.modify(book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        boolean delete = bookSer.delete(id);
        return delete ? "ok" : "error";

    }
    @GetMapping("/{id}")
    public book getById(@PathVariable Integer id){
        return bookSer.getById(id);
    }

}
