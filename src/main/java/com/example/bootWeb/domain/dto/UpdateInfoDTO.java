package com.example.bootWeb.domain.dto;

import lombok.Data;

@Data
public class UpdateInfoDTO {
    private Long memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
}
