package com.example.bootWeb.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberGender;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberAge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String memberId, String memberPw, String memberName,
                  String memberGender, String memberEmail, String memberAge, Role role) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberEmail = memberEmail;
        this.memberAge = memberAge;
        this.role = role;
    }

    public Member update(String memberPw, String memberName, String memberEmail, String memberGender, String memberAge) {
        this.memberPw = memberPw;
        this.memberName =memberName;
        this.memberEmail =memberEmail;
        this.memberGender =memberGender;
        this.memberAge =memberAge;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}