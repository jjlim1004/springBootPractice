package com.example.bootWeb.service.member;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.Password;

import java.util.ArrayList;
import java.util.Map;


public interface MemberService {

    public int join(Member member , Password password);

    public SessionMember login(String loginId, String loginPw);

    public void updateInfo(UpdateInfoDTO updateInfoDTO);

    public ArrayList<Member> getMemberList();

    public void deleteMember(Long memberNo);
}
