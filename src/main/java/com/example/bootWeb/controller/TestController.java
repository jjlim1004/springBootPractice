package com.example.bootWeb.controller;

import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

//    private MemberMapper mapper;

    @RequestMapping("/test")
    public String testPage(){
        return "testPage";
    }

    @GetMapping("/test/test")
    public String testTestPage(){
        return "testJoin";
    }

    @PostMapping("/test/test")
    public void testParam(MemberJoinDTO mjd , String memberName){
        System.out.println(mjd.getMemberName());
        System.out.println(memberName);
    }

/*    @PostMapping("/test/result")
    public String test(TestVo testVo){
        mapper.insert(testVo);
        return "testResult";
    }*/

}


