package com.onlineshopping.flipkart.repository;

import com.onlineshopping.flipkart.entity.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShipperRepository extends JpaRepository<Shippers, Integer> {
}
