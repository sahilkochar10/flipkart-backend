package com.onlineshopping.flipkart.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(Integer id) {
        super("Product Already Exist with pid : "+id);
    }
}