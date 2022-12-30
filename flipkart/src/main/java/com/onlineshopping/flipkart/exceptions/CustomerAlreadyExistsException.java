package com.onlineshopping.flipkart.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(Integer id) {
        super("Customer Already Exist with id : "+ id);
    }
}