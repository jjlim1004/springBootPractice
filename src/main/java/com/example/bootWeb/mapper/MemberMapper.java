package com.example.bootWeb.mapper;

import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.dto.MemberJoinDTO;


public interface MemberMapper {

    public void insert(MemberJoinDTO memberJoinDTO);

    public Member get(String memberId);

    public void update(UpdateInfoDTO updateInfoDTO);

    public void updatePw(UpdateInfoDTO updateInfoDTO);

}
