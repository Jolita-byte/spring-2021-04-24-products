package com.example.spring20210418products.model;

import lombok.Data;

@Data
public class StocksDTO {
    private ProductType type;
    private int pieces;
}
