package com.example.bootWeb.controller;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.dto.vo.Role;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.Password;
import com.example.bootWeb.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


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
        //session 에 소셜 로그인 한 사람은 session 이름이 socialMember , oauth2userService 에서 그렇게 정의했으니까
        //session 에 회원으로 로그인 한 사람은 session 이름이 loginMember
        SessionMember socialMember = (SessionMember) httpSession.getAttribute("socialMember");
        SessionMember loginMember =(SessionMember) httpSession.getAttribute("loginMember");
        //어짜피 model 에 보내줘야 할 내용은 공통된 테이블에 저장된 회원정보니 그냥 member 로 이름 통일
        if( socialMember != null){
            model.addAttribute("member",socialMember);
        }else if(loginMember != null){
            model.addAttribute("member",loginMember);
        }
        return "login";
    }

    @PostMapping("/login")
    public String memberLogin(Model model, HttpSession httpSession,String memberId, String memberPw){
        SessionMember result = memberService.login(memberId,memberPw);
        SessionMember sessionMember = result;
        if(sessionMember != null) {
            //추후 회원 정보 수정을 위한 session 에 넣을 데이터
            httpSession.setAttribute("loginMember", sessionMember);
            //로그인 실패시에는 jps 에서 loginMember != null 로 체크 해서 실패 메세지 뜨게
        }
        return index(model,httpSession);
    }


    @GetMapping("/join")
    public String joinPage(){
        return "join";
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
//        회원가입 시 중복된 아이디 처리 필요 ajax 로
//        else if(result == 1 ){
//
//        }
        return "join"; //이거 나중에 ajax 로 처리해야됨
    }

    @RequestMapping("/memberLogout")
    public String memberLogout(Model model,HttpSession httpSession ){
        httpSession.invalidate();
        return "redirect:login";
    }

    //어짜피 회원 수정은 일반 로그인 회원 전용 기능
    @GetMapping("/myPage")
    public void myPage(Model model, HttpSession httpSession){
        
    }

    @PostMapping("/memberUpdate")
    public String updateInfo(Model model, HttpSession httpSession, UpdateInfoDTO updateInfoDTO){
        memberService.updateInfo(updateInfoDTO);
        return "redirect:/";
    }

    @GetMapping("/adminPage")
    public String adminPage(HttpSession httpSession,Model model){
        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("loginMember");
        if(sessionMember.getRole().equals("ROLE_ADMIN")) {
            return "adminPage";
        }
        return "redirect:/";
    }

    @DeleteMapping("/delete/{memberNo}")
    public String deleteMember(HttpSession httpSession, @PathVariable("memberNo")Long memberNo){
        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("loginMember");
        if(sessionMember.getRole().equals("ROLE_ADMIN")) {
            memberService.deleteMember(memberNo);
            return "redirect:/adminPage";
        }
        return "redirect:/";
    }
}
