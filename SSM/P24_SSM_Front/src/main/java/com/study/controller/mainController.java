package com.study.controller;

import com.study.server.mainServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class mainController {
    @Autowired
    private mainServer mainServer;
}
