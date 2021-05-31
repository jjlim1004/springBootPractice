package com.example.bootWeb.domain.dto.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockInfoDTO {
    private String stockName;
    private String stockCode;
    private String stockPrice;
}
