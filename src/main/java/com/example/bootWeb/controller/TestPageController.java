package com.example.bootWeb.controller;

import com.example.bootWeb.domain.dto.PageDTO;
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
public class TestPageController {
    @Autowired
    MemberRepository memberRepository;

//    @GetMapping("/adminPage/memberList")
//    public Page<PageDTO> paging(@PageableDefault(size=15, sort = "memberNo")Pageable pageRequest){
//        Page<Member> memberList = memberRepository.findAll(pageRequest);
//
//        Page<PageDTO> pageList = memberList.map(
//            member -> new PageDTO(member.getMemberNo(),
//                    member.getMemberId(),
//                    member.getMemberName(),
//                    member.getMemberEmail(),
//                    member.getMemberAge(),
//                    member.getMemberGender())
//        );
//        return pageList;
//    }


}
