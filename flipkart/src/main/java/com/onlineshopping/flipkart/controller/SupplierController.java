package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.entity.Suppliers;
import com.onlineshopping.flipkart.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/api/v1/supplier")
    ResponseEntity<List<Suppliers>> getSuppliers(){
        return supplierService.getSuppliers();
    }
}