package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.entity.Orders;
import com.onlineshopping.flipkart.exceptions.CustomerNotFoundException;
import com.onlineshopping.flipkart.exceptions.ProductNotFoundException;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/order")
@Validated
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    ResponseEntity<List<Orders>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    ResponseEntity<String> saveOrders(@RequestBody @Valid com.onlineshopping.flipkart.vo.Orders order) throws ParseException, CustomerNotFoundException, ShipperNotFoundException, ProductNotFoundException {
        System.out.println(order);
        orderService.saveOrders(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}