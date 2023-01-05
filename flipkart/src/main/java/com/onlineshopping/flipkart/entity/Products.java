package com.onlineshopping.flipkart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products_10709374")
public class Products {

    @ManyToOne
    @JoinColumn(name = "supplierID")
    Suppliers supplier;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int productID;
    private int unit, price;
    private String productName;
    @Column(name="product_image")
    private String productImage;

}