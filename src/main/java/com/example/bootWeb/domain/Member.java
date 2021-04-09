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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_no;

    @Column(nullable = false)
    private String member_id;

    @Column
    private String member_name;

    @Column
    private String member_gender;

    @Column
    private String member_email;

    @Column
    private String member_age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String member_id, String member_name,
                  String member_gender, String member_email, String member_age, Role role) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_gender = member_gender;
        this.member_email = member_email;
        this.member_age = member_age;
        this.role = role;
    }

    public Member update(String member_name,String member_email,String member_gender, String member_age) {
        this.member_name =member_name;
        this.member_email =member_email;
        this.member_gender =member_gender;
        this.member_age =member_age;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}