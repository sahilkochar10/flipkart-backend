package com.onlineshopping.flipkart.vo;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class Orders {
    @NotNull(message = "Date is required") @Pattern(regexp = "^(2[0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][1-9]|[3][01])", message = "date should be in yyyy-mm-dd format and should be valid")
    private String date;
    @NotNull(message = "Customer Id is required")
    private int customerID;
    @NotNull(message = "Shipper Id is required")
    private int shipperID;
    @NotNull(message = "Order detail is required")
    private List<OrderDetails> orderDetails;
}