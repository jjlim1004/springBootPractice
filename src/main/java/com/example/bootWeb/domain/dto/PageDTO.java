package com.example.bootWeb.domain.dto;

import lombok.Data;

@Data
public class PageDTO {
    private Long memberNo;
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberAge;
    private String memberGender;

    public PageDTO(Long memberNo, String memberId, String memberName, String memberEmail, String memberAge, String memberGender) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAge = memberAge;
        this.memberGender = memberGender;
    }
}
