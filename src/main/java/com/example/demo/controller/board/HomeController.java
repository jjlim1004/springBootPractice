package com.example.demo.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("index")
    public String index(){

        return "index";
    }

    @RequestMapping("test")
    public String test(){

        return "investment/test";
    }
}
