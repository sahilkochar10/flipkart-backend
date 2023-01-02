package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.entity.Shippers;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.service.ShipperService;
import com.onlineshopping.flipkart.util.ValidList;
import com.onlineshopping.flipkart.vo.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/shipper")
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @GetMapping
    ResponseEntity<List<Shippers>> getShippers(){
        return shipperService.getShippers();
    }

    @PostMapping
    ResponseEntity<String> saveShippers(@RequestBody ValidList<Shipper> shippers) throws ShipperNotFoundException {
        shipperService.saveShippers(shippers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateShippers(@RequestBody @Valid List<com.onlineshopping.flipkart.vo.Shipper> shippers) throws ShipperNotFoundException {
        shipperService.updateShippers(shippers);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
