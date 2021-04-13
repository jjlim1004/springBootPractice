package com.example.bootWeb.mapper;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.TestVo;

public interface MemberMapper {

    public void insert(Member member);

    public Member get(String memberId);
}
