package com.example.bootWeb.controller;

import com.example.bootWeb.domain.TestVo;
import com.example.bootWeb.mapper.TestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@AllArgsConstructor
public class TestController {

    private TestMapper mapper;

    @RequestMapping("/test")
    public String testPage(){
        return "testPage";
    }

    @PostMapping("/test/result")
    public String test(TestVo testVo){
        mapper.insert(testVo);
        return "testResult";
    }

}
