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
    public boolean save(@RequestBody book book) {
        return bookservice.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody book book) {
        return bookservice.update(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookservice.delete(id);
    }

    @GetMapping("/{id}")
    public book getById(@PathVariable Integer id) {
        return bookservice.getById(id);
    }

    @GetMapping
    public List<book> getAll() {
        return bookservice.getAll();
    }

}
