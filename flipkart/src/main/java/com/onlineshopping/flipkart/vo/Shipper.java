package com.onlineshopping.flipkart.vo;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class Shipper {
    int shipperID;
    @NotEmpty
    int phone;
    @NotEmpty
    String shipperName;
}