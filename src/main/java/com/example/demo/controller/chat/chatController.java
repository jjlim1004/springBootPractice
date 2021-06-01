package com.example.demo.controller.chat;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/")
public class chatController {

    @GetMapping("talk")
    public String talk(){
        return "chat/talk";
    }
}
