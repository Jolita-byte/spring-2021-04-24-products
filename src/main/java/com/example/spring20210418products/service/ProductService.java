package com.example.spring20210418products.service;

import com.example.spring20210418products.configure.ProductPrice;
import com.example.spring20210418products.handlers.InsuficientProductQuantity;
import com.example.spring20210418products.model.Product;
import com.example.spring20210418products.model.ProductDTO;
import com.example.spring20210418products.model.ProductType;
import com.example.spring20210418products.repository.ProductRepository;
import com.example.spring20210418products.repository.StockRepository;
import com.example.spring20210418products.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    //Map<ProductType, Double> allProductsPrices;
    //Map<ProductType, Integer> allProductStocks;
    ProductValidator productValidator;
    ProductRepository productRepository;
    StockRepository stockRepository;

    @Autowired
    public ProductService(ProductValidator productValidator, ProductRepository productRepository, StockRepository stockRepository) {
        this.productValidator = productValidator;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    public Map<ProductType, Double> allProductPrices(){
        Map<ProductType, Double> productPrices = new HashMap<>();
        productPrices.put(ProductType.APPLE, productRepository.findByType(ProductType.APPLE));
        productPrices.put(ProductType.ORANGE, productRepository.findByType(ProductType.ORANGE));
        productPrices.put(ProductType.CARROT, productRepository.findByType(ProductType.CARROT));
        productPrices.put(ProductType.POTATO, productRepository.findByType(ProductType.POTATO));
        return productPrices;
    }

    public Double getPriceByType(ProductType type){
        return allProductPrices().get(type);
    }

    public void validateCartInStock(Map<ProductType, Integer> cart) {
        productValidator.sufficientProductInStock(cart, allProductStocks());
    }

    public Double calculateCartPrice(Map<ProductType, Integer> cart){
        double sum = 0;
        double price = 0;
        for (Map.Entry<ProductType, Integer> productTypeAndAmount : cart.entrySet()){
            ProductType productType = productTypeAndAmount.getKey();
            int amount = productTypeAndAmount.getValue();
            //allProductStocks.put(productType, allProductStocks.get(productType)-amount);
            price= getPriceByType(productType);
            sum += price * amount;
        }
        return sum;
    }

    public Map<ProductType, Integer> allProductStocks(){
        Map<ProductType, Integer> productStocks = new HashMap<>();
        productStocks.put(ProductType.APPLE, stockRepository.findByType(ProductType.APPLE));
        productStocks.put(ProductType.ORANGE, stockRepository.findByType(ProductType.ORANGE));
        productStocks.put(ProductType.CARROT, stockRepository.findByType(ProductType.CARROT));
        productStocks.put(ProductType.POTATO, stockRepository.findByType(ProductType.POTATO));
        return productStocks;
    }

    public Integer getStockByType(ProductType type){
        return stockRepository.findByType(type);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product registerProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }
}
