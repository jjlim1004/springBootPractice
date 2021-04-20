package com.example.bootWeb.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="password")
@SequenceGenerator(sequenceName = "passwordSeq",name="passwordSeq",initialValue = 1,allocationSize = 1)
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "passwordSeq")
    private Long pwId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "member_memberId")
    private Member member;

    @Column(nullable = false)
    private String pw;

    @Builder
    public Password(Member member, String pw) {
        this.member = member;
        this.pw = pw;
    }
}
