package com.onlineshopping.flipkart.repository;


import com.onlineshopping.flipkart.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers,Integer> {
}
