package com.onlineshopping.flipkart.vo;

import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
public class Products {
    private int productID;
    @Min(value = 1,message = "At least 1 unit required")
    private int unit;
    @Min(value = 10, message = "Minimum price should be 10")
    private int price;
    private int supplierID;
    @NotBlank(message = "Product Name can not be empty")
    private String productName;
}
