package com.onlineshopping.flipkart.repository;

import com.onlineshopping.flipkart.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Products, Integer> {
}
