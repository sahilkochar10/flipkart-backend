package com.onlineshopping.flipkart.exceptions;

public class SupplierNotFoundException extends RuntimeException{
    public SupplierNotFoundException(Integer id) {
        super("No supplier found with id "+id);
    }
}