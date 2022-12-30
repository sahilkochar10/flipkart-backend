package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.entity.Shippers;
import com.onlineshopping.flipkart.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shipper")
    ResponseEntity<List<Shippers>> getShippers(){
        return shipperService.getShippers();
    }
}
