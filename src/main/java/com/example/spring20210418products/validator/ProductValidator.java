package com.example.spring20210418products.validator;

import com.example.spring20210418products.handlers.InsuficientProductQuantity;
import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductValidator {

    public boolean sufficientProductInStock(Map<ProductType, Integer> cart, Map<ProductType, Integer> stock) {
        for (Map.Entry<ProductType, Integer> productTypeAndAmount : cart.entrySet()) {
            if (productTypeAndAmount.getValue() > stock.get(productTypeAndAmount.getKey())){
                throw new InsuficientProductQuantity("Not enough " + productTypeAndAmount.getKey().toString() + " in stock");
            }
        } return true;
    }
}
