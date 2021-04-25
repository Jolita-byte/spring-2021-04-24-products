package com.example.spring20210418products.repository;

import com.example.spring20210418products.model.Product;
import com.example.spring20210418products.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Double findByType(ProductType type);
}
