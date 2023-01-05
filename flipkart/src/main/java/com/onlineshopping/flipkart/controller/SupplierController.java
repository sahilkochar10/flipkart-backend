package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.entity.Suppliers;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.exceptions.SupplierNotFoundException;
import com.onlineshopping.flipkart.service.SupplierService;
import com.onlineshopping.flipkart.util.ValidList;
import com.onlineshopping.flipkart.vo.Shipper;
import com.onlineshopping.flipkart.vo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    ResponseEntity<List<Suppliers>> getSuppliers(){
        return supplierService.getSuppliers();
    }

    @PostMapping
    ResponseEntity<String> saveSuppliers(@RequestBody ValidList<Supplier> suppliers) throws SupplierNotFoundException {
        supplierService.saveSuppliers(suppliers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateSuppliers(@RequestBody @Valid List<com.onlineshopping.flipkart.vo.Supplier> suppliers) throws SupplierNotFoundException {
        supplierService.updateSuppliers(suppliers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{suppid}")
    ResponseEntity<com.onlineshopping.flipkart.entity.Suppliers> deleteSupplierBySuppid(@PathVariable Integer suppid) throws SupplierNotFoundException {
        supplierService.deleteSupplierById(suppid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}