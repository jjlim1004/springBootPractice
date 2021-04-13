package com.example.bootWeb.mapper;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.TestVo;
import com.example.bootWeb.domain.dto.MemberJoinDTO;

public interface MemberMapper {

    public void insert(MemberJoinDTO memberJoinDTO);

    public Member get(String memberId);
}
