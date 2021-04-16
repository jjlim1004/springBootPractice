package com.example.bootWeb.service.member;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.domain.vo.entity.Member;
import com.example.bootWeb.domain.vo.entity.Password;

import java.util.Map;


public interface MemberService {

    public int join(Member member , Password password);

    public Map<Integer, SessionMember> login(String loginId, String loginPw);
}
