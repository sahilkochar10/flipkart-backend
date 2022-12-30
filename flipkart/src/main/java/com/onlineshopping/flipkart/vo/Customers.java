package com.onlineshopping.flipkart.vo;

import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Getter
public class Customers {
    int customerID;
    @Digits(integer = 6, fraction = 0)
    int postalCode;
    @NotEmpty(message = "Customer Name must be filled")
    String customerName;
    @NotEmpty(message = "Address must be filled")
    String address;
    @NotEmpty(message = "City must be filled")
    String city;
    @NotEmpty(message = "Country must be filled")
    String country;
}