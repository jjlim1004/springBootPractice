package com.example.bootWeb.service.member;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.MemberRepository;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

//    @Autowired
//    MemberMapper memberMapper;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) {
        memberRepository.save(memberJoinDTO.toEntity());
    }
}
