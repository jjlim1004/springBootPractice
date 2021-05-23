package com.example.demo.controller.member;

import com.example.demo.config.SessionMember;
import com.example.demo.domain.Criteria;
import com.example.demo.domain.PageDTO;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


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
   public ResponseEntity<Member> get(@PathVariable("member_id") String id, HttpSession httpSession){
        id = id.replace(".json", "");
        System.out.println("adminController에서 왔어요"+ id);
        httpSession.setAttribute("member", memberService.get(id));
        return new ResponseEntity<>(memberService.get(id), HttpStatus.OK);
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
