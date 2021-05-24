package com.example.demo.controller.member;

import com.example.demo.config.SessionMember;
import com.example.demo.domain.Criteria;
import com.example.demo.domain.PageDTO;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.service.member.MemberService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RequestMapping("/admin/")
@RestController
@AllArgsConstructor
public class AdminController {

    MemberService memberService;

    public SessionMember adminSessionCheck(HttpSession httpSession){
        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("loginMember");

        return sessionMember;
    }



   //get
   @GetMapping(value ="/{member_id}", produces = {"application/json"})
   public String get(@PathVariable("member_id") String id, HttpSession httpSession, Model model){

       Member member = memberService.get(id);

       JsonObject obj = new JsonObject();
       obj.addProperty("no",member.getMemberNo());
       obj.addProperty("id",member.getMemberId());
       obj.addProperty("name",member.getMemberName());
       obj.addProperty("email",member.getMemberEmail());
       obj.addProperty("age",member.getMemberAge());
       obj.addProperty("gender", member.getMemberGender());

       return obj.toString();
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
