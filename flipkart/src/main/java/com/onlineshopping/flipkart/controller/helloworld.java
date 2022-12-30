package com.onlineshopping.flipkart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {
    @GetMapping("/")
    public String sendhello() {
        return "hello world";
    }
    @GetMapping("/sahil")
    public String sendhellosahil() {
        return "hello sahil";
    }
}
