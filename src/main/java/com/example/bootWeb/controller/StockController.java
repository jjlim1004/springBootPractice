package com.example.bootWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/news")
    public void newPage(){
        //templates/news.mustache
    }

    @GetMapping("/stockPage")
    public void stockPage(){

    }

    @GetMapping("/stockDetail")
    public void stockDetail(@RequestParam("stock_code") String stockCode){
        System.out.println(stockCode);
    }
}
