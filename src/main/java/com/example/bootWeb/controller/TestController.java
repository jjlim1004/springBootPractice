package com.example.bootWeb.controller;

import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.domain.dto.MemberListDTO;
import com.example.bootWeb.domain.dto.vo.Criteria;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/test")
@Controller
@AllArgsConstructor
public class TestController {

    private MemberMapper mapper;

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


//    @GetMapping("/mapperTest")
//    public String mapperTest(){
//        List<MemberListDTO> list = mapper.getListWithPaging(new Criteria());
//        MemberListDTO member = list.get(1);
//        System.out.println(member.getMember_id());
////        System.out.println(member.getMemberNo());
////        System.out.println(member.getMemberAge());
//
//        return "test";
//    }



}


