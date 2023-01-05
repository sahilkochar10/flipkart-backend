package com.onlineshopping.flipkart.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers_10709374")
public class Suppliers {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int supplierID;
    private int postalCode;
    private String supplierName, address, city;
}
