package com.example.bootWeb.service.member;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    MemberMapper memberMapper;

    @Override
    public void join(Member member) {
        memberMapper.insert(member);
    }
}
