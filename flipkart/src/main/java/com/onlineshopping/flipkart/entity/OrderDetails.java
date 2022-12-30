package com.onlineshopping.flipkart.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "OrderDetails_10709374")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @Min(value = 1, message = "Minimum 1 quantity is required")
    int quantity;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products product;

}
