package com.example.bootWeb.controller;

import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

    private MemberMapper mapper;

    @RequestMapping("/test")
    public String testPage(){
        return "testPage";
    }

/*    @PostMapping("/test/result")
    public String test(TestVo testVo){
        mapper.insert(testVo);
        return "testResult";
    }*/

}
