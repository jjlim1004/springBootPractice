package com.example.bootWeb.controller;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.Role;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.service.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
//@RequiredArgsConstructor
public class loginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }


    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/join")
    public void joinPage(){
    }

    @PostMapping("/join")
    public String join(MemberJoinDTO memberJoinDTO){
        memberJoinDTO.setRole(Role.USER);

//        System.out.println(memberJoinDTO.getMemberId() + "****" +
//                        memberJoinDTO.getMemberPw()+ "****" +
//                        memberJoinDTO.getMemberName()+ "****" +
//                        memberJoinDTO.getMemberGender()+ "****" +
//                        memberJoinDTO.getMemberEmail()+ "****" +
//                        memberJoinDTO.getMemberAge()+ "****" +
//                        memberJoinDTO.getRole()
//                );

        memberService.join(memberJoinDTO);
        return "login";
    }

}
