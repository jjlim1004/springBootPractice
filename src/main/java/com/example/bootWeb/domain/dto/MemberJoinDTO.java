package com.example.bootWeb.domain.dto;


import com.example.bootWeb.domain.vo.entity.Member;
import com.example.bootWeb.domain.vo.Role;
import lombok.Data;


@Data
public class MemberJoinDTO {

    private String memberId;

    private String memberName;

    private String memberGender;

    private String memberEmail;
   
    private String memberAge;

    private Role role;

    public Member toEntity(){
        Member member = Member.builder()
                .memberId(memberId)
                .memberName(memberName)
                .memberGender(memberGender)
                .memberEmail(memberEmail)
                .memberAge(memberAge)
                .role(role)
                .build();

        return member;
    }

}
