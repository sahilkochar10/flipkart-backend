package com.onlineshopping.flipkart.vo;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class Supplier {
    int supplierID;
    @NotEmpty
    String Address;
    @NotEmpty
    String City;
    @NotEmpty
    int postalCode;
    @NotEmpty
    String supplierName;
}