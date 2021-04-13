package com.example.bootWeb.service.member;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.dto.MemberJoinDTO;
import org.springframework.stereotype.Service;


public interface MemberService {

    public void join(MemberJoinDTO memberJoinDTO);

}
