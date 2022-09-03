package com.test.controller;

import com.test.domain.book;
import com.test.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/books")
public class bookController {
    @Autowired
    private bookservice bookservice;

    @PostMapping
    public result save(@RequestBody book book) {
        boolean flag=bookservice.save(book);
        return new result(flag?code.SAVE_OK:code.SAVE_ERR,flag);
    }

    @PutMapping
    public result update(@RequestBody book book) {
        boolean flag=bookservice.update(book);
        return new result(flag?code.UPDATE_OK:code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public result delete(@PathVariable Integer id) {
        boolean flag=bookservice.delete(id);
        return new result(flag?code.DELETE_OK:code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public result getById(@PathVariable Integer id) {
        book book=bookservice.getById(id);
        Integer get_code=book!=null?code.GET_OK:code.GET_ERR;
        String msg=book!=null?"":"查询失败";
        return new result(get_code,book,msg);
    }

    @GetMapping
    public result getAll() {
        List<book> bookList=bookservice.getAll();
        Integer get_code=bookList!=null?code.GET_OK:code.GET_ERR;
        String msg=bookList!=null?"":"查询失败";
        return new result(get_code,bookList,msg);
    }

}
