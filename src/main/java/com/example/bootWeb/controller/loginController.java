package com.example.bootWeb.controller;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class loginController {
//    @RequestMapping("/")
//    public String mainPage(){
//        return login();
//    }

    MemberService memberService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public void joinPage(){
    }

    @PostMapping("/join")
    public void join(Member member){

        memberService.join(member);
    }

}
