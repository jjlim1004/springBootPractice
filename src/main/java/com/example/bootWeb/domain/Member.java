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
    public Member(String member_id, String member_name,
                  String member_gender, String member_email, String member_age, Role role) {
        this.memberId = member_id;
        this.memberName = member_name;
        this.memberGender = member_gender;
        this.memberEmail = member_email;
        this.memberAge = member_age;
        this.role = role;
    }

    public Member update(String member_name, String member_email, String member_gender, String member_age) {
        this.memberName =member_name;
        this.memberEmail =member_email;
        this.memberGender =member_gender;
        this.memberAge =member_age;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}