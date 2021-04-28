package com.example.bootWeb.domain.dto.vo;

import lombok.Data;

@Data
public class Criteria {

    //한 뷰에서 보여줄 페이지 수
    private int pageCount;
    //한 페이지 당 존재하는 글의 개수
    private int contentNum;

    private String type;
    private String keyword;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageCount, int contentNum) {
        this.pageCount = pageCount;
        this.contentNum = contentNum;
    }

    public String[] getTypeArr() {
        return type == null ? new String[] {}: type.split("");
    }
}
