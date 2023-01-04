package com.onlineshopping.flipkart.exceptions;

public class ShipperAlreadyExistsException extends RuntimeException {
    public ShipperAlreadyExistsException(Integer shipid) {
        super("Shipper Already Exist with ship id : "+shipid);
    }
}