package com.example.bootWeb.domain.dto;

import com.example.bootWeb.domain.dto.vo.Criteria;
import lombok.Data;

@Data
public class PageDTO {

    private int startPage; // 맨 마지막의 페이지
    private int endPage; // 한 페이지에 보여지는 끝
    private boolean prev, next;

    private int total;
    private Criteria cri;

    public PageDTO(Criteria cri, int total) {

        this.cri = cri;
        this.total = total;

        this.endPage = (int) (Math.ceil(cri.getContentNum() / 10.0)) * 10;

        this.startPage = this.endPage - 9;

        int realEnd = (int) (Math.ceil((total * 1.0) / cri.getPageCount()));

        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;

        this.next = this.endPage < realEnd;
    }
}
