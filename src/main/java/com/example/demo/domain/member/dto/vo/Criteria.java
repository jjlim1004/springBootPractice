package com.example.demo.domain.member.dto.vo;


import lombok.Data;

@Data
public class Criteria {
    private int amount; //한 페이지 당 나타나는 회원수
    private int curPage; //현재 나타나는 화면의 페이지

    public Criteria(){
        this(10,1);
    }

    public Criteria(int amount, int curPage) {
        this.amount = amount;
        this.curPage = curPage;
    }
}
