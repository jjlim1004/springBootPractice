package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("main")
    public String main(){

        return "main";
    }

    @RequestMapping("test")
    public String test(){

        return "investment/test";
    }

}
