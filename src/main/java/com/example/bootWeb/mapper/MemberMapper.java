package com.example.bootWeb.mapper;

import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.dto.vo.Criteria;
import com.example.bootWeb.domain.dto.vo.test.TestPageDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.dto.MemberJoinDTO;

import java.util.List;


public interface MemberMapper {

    public void insert(MemberJoinDTO memberJoinDTO);

    public Member get(String memberId);

    public void update(UpdateInfoDTO updateInfoDTO);

    public void updatePw(UpdateInfoDTO updateInfoDTO);

    public List<Member> getListWithPaging(Criteria cri);

}
