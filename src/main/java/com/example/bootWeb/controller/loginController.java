package com.example.bootWeb.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class loginController {
    @RequestMapping("/naverLogin")
    public String naverlogin(){
        return "naverLogin";
    }

}
