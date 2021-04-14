package com.example.bootWeb.controller;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dao.LoginMember;
import com.example.bootWeb.domain.vo.Role;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
//@RequiredArgsConstructor
public class loginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/")
    public String index(Model model,HttpSession httpSession){
        return login( model, httpSession);
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession httpSession){
        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("socialMember");
        if( sessionMember != null){
            model.addAttribute("socialMember",sessionMember);
        }
//        LoginMember loginMember = (LoginMember) httpSession.getAttribute("loginMember");
//        else if(httpSession.getAttribute("loginMember") != null){
//            model.addAttribute("loginMember",);
//        }
        return "login";
    }

//    @PostMapping("/login")
//    public String memberLogin(Model model, HttpSession httpSession,String id, String pw){
//
//        httpSession.setAttribute("loginMember",);
//    }


    @GetMapping("/join")
    public void joinPage(){
    }

    @PostMapping("/join")
    public String join(MemberJoinDTO memberJoinDTO){
        memberJoinDTO.setRole(Role.USER);
        memberService.join(memberJoinDTO);
        return "login";
    }

}
