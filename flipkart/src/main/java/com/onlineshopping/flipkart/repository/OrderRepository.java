package com.onlineshopping.flipkart.repository;

import com.onlineshopping.flipkart.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface OrderRepository extends JpaRepository<Orders, Integer> {
    }

