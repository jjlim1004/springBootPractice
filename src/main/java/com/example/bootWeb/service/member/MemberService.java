package com.example.bootWeb.service.member;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.MemberListDTO;
import com.example.bootWeb.domain.dto.PageDTO;
import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.dto.vo.Criteria;
import com.example.bootWeb.domain.dto.vo.test.TestPageDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.Password;

import java.util.ArrayList;
import java.util.List;


public interface MemberService {

    public int join(Member member , Password password);

    public String idCheck(String memberId);

    public SessionMember login(String loginId, String loginPw);

    public void updateInfo(UpdateInfoDTO updateInfoDTO);

    public void memberOut(String memberId);

    public int totalCount();

    public  List<MemberListDTO> getList(Criteria cri);

    public void deleteMember(Long memberNo);


}
