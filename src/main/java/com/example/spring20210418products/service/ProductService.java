package com.example.spring20210418products.service;

import com.example.spring20210418products.configure.ProductPrice;
import com.example.spring20210418products.handlers.InsuficientProductQuantity;
import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    Map<ProductType, Double> allProductsPrices;
    Map<ProductType, Integer> allProductStocks;
    ProductValidator productValidator;

    @Autowired
    public ProductService(Map<ProductType, Double> allProductsPrices, Map<ProductType, Integer> allProductStocks, ProductValidator productValidator) {
        this.allProductsPrices = allProductsPrices;
        this.allProductStocks = allProductStocks;
        this.productValidator = productValidator;
    }

    public Map<ProductType, Double> allProductPrices(){
        return allProductsPrices;
    }

    public Double getPriceByType(ProductType type){
        return allProductPrices().get(type);
    }

    public void validateCartInStock(Map<ProductType, Integer> cart) {
        productValidator.sufficientProductInStock(cart, allProductStocks);
    }

    public Double calculateCartPrice(Map<ProductType, Integer> cart){
        double sum = 0;
        double price = 0;
        for (Map.Entry<ProductType, Integer> productTypeAndAmount : cart.entrySet()){
            ProductType productType = productTypeAndAmount.getKey();
            int amount = productTypeAndAmount.getValue();
            allProductStocks.put(productType, allProductStocks.get(productType)-amount);
            price= getPriceByType(productType);
            sum += price * amount;
        }
        return sum;
    }

    public Map<ProductType, Integer> allProductStocks(){
        return allProductStocks;
    }

    public Integer getStockByType(ProductType type){
        return allProductStocks.get(type);
    }

}
