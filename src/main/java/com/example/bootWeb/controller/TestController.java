package com.example.bootWeb.controller;

import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@Controller
@AllArgsConstructor
public class TestController {

//    private MemberMapper mapper;

    @GetMapping("/test")
    public String testPage(){
        return "test";
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

    @GetMapping("/test/restTest/string")
    @ResponseBody
    public String testString(){
        String testValue = "rest test";
        return testValue;
    }

    @GetMapping("/test/jsp")
    public String jpsTest(){
        return "forTest/test";
    }

    @GetMapping("/test/voidJsp")
    public String voidJsp(){
        return "voidJsp";
    }





}


