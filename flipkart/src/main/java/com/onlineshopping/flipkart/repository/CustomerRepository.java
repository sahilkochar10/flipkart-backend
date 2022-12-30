package com.onlineshopping.flipkart.repository;

import com.onlineshopping.flipkart.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
