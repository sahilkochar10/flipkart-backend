package com.onlineshopping.flipkart.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("No product found with id "+id);
    }
}
//remove hard coding
