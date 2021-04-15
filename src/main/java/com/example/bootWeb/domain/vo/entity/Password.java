package com.example.bootWeb.domain.vo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pwId;

    @OneToOne
    @JoinColumn(name="memberId")
    private Member memberId;

    private String pw;
}
//https://medium.com/@SlackBeck/%EC%A4%91%EC%B2%A9%EB%90%9C-fk-foreign-key-%EB%A5%BC-jpa%EB%A1%9C-%EC%97%B0%EA%B4%80-%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91-%ED%95%98%EA%B8%B0-216ba5f2b8ed