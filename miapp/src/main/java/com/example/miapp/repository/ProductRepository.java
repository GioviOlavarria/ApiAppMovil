package com.example.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
