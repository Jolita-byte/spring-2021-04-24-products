package com.example.spring20210418products.controler;

import com.example.spring20210418products.configure.ProductConverter;
import com.example.spring20210418products.model.Product;
import com.example.spring20210418products.model.ProductDTO;
import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.service.ProductService;
import com.example.spring20210418products.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/products")

public class ProductControler {
    private ProductService productService;
    private ProductValidator productValidator;
    private final ProductConverter productConverter;

    @Autowired
    public ProductControler(ProductService productService, ProductValidator productValidator, ProductConverter productConverter) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.productConverter = productConverter;
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

//    @PostMapping
//    public Product registerProduct(@RequestBody ProductDTO productDTO){
//        return productService.registerProduct(productDTO);
//    }


    @GetMapping(value = "/prices")
    public Map<ProductType, Double> getPrices(){
        return productService.allProductPrices();
    }

    @GetMapping(value = "/{type}")
    public Double getPrice(@PathVariable String type){
        return productService.getPriceByType(productConverter.convert(type));
    }

    @PostMapping(value = "/cart")
    public Double CalculateCartPrice(@RequestBody Map<ProductType, Integer> cart){
        productService.validateCartInStock(cart);
        return productService.calculateCartPrice(cart);

    }



}
