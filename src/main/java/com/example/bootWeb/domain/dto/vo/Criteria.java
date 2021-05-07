package com.example.bootWeb.domain.dto.vo;


import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class Criteria {

//    원래 코드
//    private int amount; //한 페이지 당 나타나는 회원수
//    private int curPage; //현재 나타나는 화면의 페이지
//
//    public Criteria(){
//        this(10,1);
//    }
//
//    public Criteria(int amount, int curPage) {
//        this.amount = amount;
//        this.curPage = curPage;
//    }

    private Integer pageNum;    //페이지번호
    private Integer amount;     //한 페이지당 게시물 수

    private String type;    //검색 기준(조건) - title / content / writer
    private String keyword; //검색 내용

    public Criteria(){
        this(1, 10);
    }

    public Criteria(Integer pageNum, Integer amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypeArr(){

        return type == null? new String[] {}: type.split("");
    }

    public String getListLink(){

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.getPageNum())
                .queryParam("amount", this.getAmount())
                .queryParam("type", this.getType())
                .queryParam("keyword", this.getKeyword());


        return builder.toUriString();
    }
}
