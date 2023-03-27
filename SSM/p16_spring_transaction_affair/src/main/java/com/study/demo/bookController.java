package com.study.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class bookController {
    @Autowired
    private bookServer bookServer;

    public void byBook(Integer bookId,Integer userID){
        bookServer.buyBook(bookId,userID);
    }

}
