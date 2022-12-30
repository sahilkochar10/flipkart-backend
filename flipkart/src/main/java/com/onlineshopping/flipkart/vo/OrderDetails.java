package com.onlineshopping.flipkart.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetails {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "Product ID is required")
    private int productID;
}
