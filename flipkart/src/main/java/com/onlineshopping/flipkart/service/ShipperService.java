package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.Shippers;
import org.springframework.http.ResponseEntity;
import com.onlineshopping.flipkart.repository.ShipperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Shippers>> getShippers() {
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }
}