package com.commerce.commerce_backend.repository;

import com.commerce.commerce_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}