package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.Suppliers;
import com.onlineshopping.flipkart.repository.SupplierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
    public ResponseEntity<List<Suppliers>> getSuppliers() {
        return new ResponseEntity<>(supplierRepository.findAll(), HttpStatus.OK);
    }
}