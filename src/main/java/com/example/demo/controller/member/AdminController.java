package com.example.demo.controller.member;

import com.example.demo.config.SessionMember;
import com.example.demo.domain.Criteria;
import com.example.demo.domain.PageDTO;
import com.example.demo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


public class AdminController {

    @Autowired
    MemberService memberService;

    @GetMapping("/adminPage")
    public String adminPage(HttpSession httpSession , Model model, Criteria cri ){
        SessionMember sessionMember = (SessionMember)httpSession.getAttribute("admin");
        if(sessionMember!=null) {
            model.addAttribute("list",memberService.getList(cri));
            System.out.println(memberService.totalCount());
            PageDTO page = new PageDTO(cri,memberService.totalCount());
            System.out.println(page.getStartPage());
            System.out.println(page.getEndPage());
            model.addAttribute("pageMaker",page);
            return "/member/adminPage";
        }
        return "redirect:/";
    }

    public SessionMember adminSessionCheck(HttpSession httpSession){
        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("loginMember");

        return sessionMember;
    }

    @DeleteMapping("/delete/{memberNo}")
    public String deleteMember(HttpSession httpSession, @PathVariable("memberNo")Long memberNo){
        SessionMember sessionMember = adminSessionCheck(httpSession);
        if(sessionMember.getRole().equals("ROLE_ADMIN")) {
            httpSession.setAttribute("admin",sessionMember);
            memberService.deleteMember(memberNo);
            return "redirect:/adminPage";
        }
        return "redirect:/";
    } //post - requestParam

}
