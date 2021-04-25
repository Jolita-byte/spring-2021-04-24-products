package com.example.spring20210418products.repository;

import com.example.spring20210418products.model.Product;
import com.example.spring20210418products.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Product, Long> {
    Integer findByType(ProductType type);
}
