package com.onlineshopping.flipkart.vo;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class Supplier {
    int supplierID;
    @NotEmpty
    String address;
    @NotEmpty
    String city;
    @NotEmpty
    int postalCode;
    @NotEmpty
    String supplierName;
}