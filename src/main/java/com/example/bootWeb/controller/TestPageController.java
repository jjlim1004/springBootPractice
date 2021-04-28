package com.example.bootWeb.controller;


import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.vo.test.TestPageDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://semtax.tistory.com/77
@RestController
@RequiredArgsConstructor
public class PageController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/adminPage/testPageDto")
    public Page<TestPageDTO> paging(@PageableDefault(size=15, sort = "memberNo")Pageable pageRequest){

        Page<Member> memberList = memberRepository.findAll(pageRequest);

        Page<TestPageDTO> pageList = memberList.map(
            member -> new TestPageDTO(member)
        );
        return pageList;
    }
}
