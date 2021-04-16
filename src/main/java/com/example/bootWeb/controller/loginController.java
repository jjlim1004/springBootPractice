package com.example.bootWeb.controller;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dao.LoginMember;
import com.example.bootWeb.domain.vo.Role;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.domain.vo.entity.Member;
import com.example.bootWeb.domain.vo.entity.Password;
import com.example.bootWeb.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class loginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/")
    public String index(Model model,HttpSession httpSession){
        return login( model, httpSession);
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession httpSession){
        SessionMember socialMember = (SessionMember) httpSession.getAttribute("socialMember");
        SessionMember loginMember =(SessionMember) httpSession.getAttribute("loginMember");
        if( socialMember != null){
            model.addAttribute("member",socialMember);
        }else if(loginMember != null){
            model.addAttribute("member",loginMember);
        }
        return "login";
    }

    @PostMapping("/login")
    public String memberLogin(Model model, HttpSession httpSession,String memberId, String memberPw){
        Map<Integer,SessionMember> result = memberService.login(memberId,memberPw);
        SessionMember sessionMember = result.get(0);
        httpSession.setAttribute("loginMember",sessionMember);
        return index(model,httpSession);
    }


    @GetMapping("/join")
    public void joinPage(){
    }

    @PostMapping("/join")
    public String join(MemberJoinDTO memberJoinDTO,String memberPw){
        memberJoinDTO.setRole(Role.USER);
        Member member = memberJoinDTO.toEntity();
        Password password =  Password.builder()
                .member(member)
                .pw(memberPw)
                .build();
        int result = memberService.join(member,password);
        if(result == 0){
            return "redirect:login";
        }
        return "join"; //이거 나중에 ajax 로 처리해야됨
    }

    @RequestMapping("/memberLogout")
    public String memberLogout(Model model,HttpSession httpSession ){
        httpSession.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/myPage")
    public String myPage(Model model, HttpSession httpSession){

        return "myPage";
    }

}
