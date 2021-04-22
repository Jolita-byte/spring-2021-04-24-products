package com.example.spring20210418products.controler;

import com.example.spring20210418products.handlers.InsuficientProductQuantity;
import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.service.ProductService;
import com.example.spring20210418products.validator.ProductValidator;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/products")

public class ProductControler {
    private ProductService productService;
    private ProductValidator productValidator;

    @Autowired
    public ProductControler(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @GetMapping
    public Map<ProductType, Double> getPrices(){
        return productService.allProductPrices();
    }

    @GetMapping(value = "/{type}")
    public Double getPrice(@PathVariable ProductType type){
        return productService.getPriceByType(type);
    }

    @PostMapping(value = "/cart")
    public Double CalculateCartPrice(@RequestBody Map<ProductType, Integer> cart){
        productService.validateCartInStock(cart);
/*        try {
            productService.validateCartInStock(cart);
        } catch (InsuficientProductQuantity insuficientProductQuantity) {
            insuficientProductQuantity.printStackTrace();
        }*/
        return productService.calculateCartPrice(cart);

    }



}
