package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.exceptions.CustomerAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.CustomerNotFoundException;
import com.onlineshopping.flipkart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.onlineshopping.flipkart.util.ValidList;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    ResponseEntity<List<com.onlineshopping.flipkart.entity.Customers>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping
    ResponseEntity<String> saveCustomer(@RequestBody @Valid ValidList<com.onlineshopping.flipkart.vo.Customers> customers) throws CustomerAlreadyExistsException {
        customerService.saveCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateCustomer(@RequestBody @Valid ValidList<com.onlineshopping.flipkart.vo.Customers> customers) throws CustomerNotFoundException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
