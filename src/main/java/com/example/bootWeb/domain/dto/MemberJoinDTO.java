package com.example.bootWeb.domain.dto;


import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.Role;
import lombok.Data;


@Data
public class MemberJoinDTO {

    private String memberId;

    private String memberPw;

    private String memberName;

    private String memberGender;

    private String memberEmail;
   
    private String memberAge;

    private Role role;

    public Member toEntity(){
        Member member = Member.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .memberName(memberName)
                .memberGender(memberGender)
                .memberEmail(memberEmail)
                .memberAge(memberAge)
                .role(role)
                .build();

        return member;
    }

}
