package com.onlineshopping.flipkart.exceptions;

public class SupplierAlreadyExistsException extends RuntimeException {
    public SupplierAlreadyExistsException(Integer suppid) {
        super("Supplier Already Exist with ship id : "+suppid);
    }
}