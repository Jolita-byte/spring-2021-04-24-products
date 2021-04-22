package com.example.spring20210418products.configure;

import com.example.spring20210418products.model.ProductType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<String, ProductType>{


    @Override
    public ProductType convert(String s) {
        return ProductType.valueOf(s.toUpperCase());
    }
}
