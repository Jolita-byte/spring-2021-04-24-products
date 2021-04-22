package com.example.spring20210418products.configure;

import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.validator.ProductValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductConfig {

    @Bean
    public Map<ProductType, Double> allProductPrices(ProductPrice productPrice){
        Map<ProductType, Double> productPrices = new HashMap<>();
        productPrices.put(ProductType.APPLE, productPrice.getApplePrice());
        productPrices.put(ProductType.ORANGE, productPrice.getOrangePrice());
        productPrices.put(ProductType.CARROT, productPrice.getCarrotPrice());
        productPrices.put(ProductType.POTATO, productPrice.getPotatoPrice());
        return productPrices;
    }

    @Bean
    public Map<ProductType, Integer> allProductStocks(ProductInitialStock productInitialStock){
        Map<ProductType, Integer> productStocks = new HashMap<>();
        productStocks.put(ProductType.APPLE, productInitialStock.getApple());
        productStocks.put(ProductType.ORANGE, productInitialStock.getOrange());
        productStocks.put(ProductType.CARROT, productInitialStock.getCarrot());
        productStocks.put(ProductType.POTATO, productInitialStock.getPotato());
        return productStocks;
    }

    @Bean
    public ProductValidator productValidator (){
        return new ProductValidator();
    }

}
