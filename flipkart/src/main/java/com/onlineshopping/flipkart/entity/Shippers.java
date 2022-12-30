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
@Table(name = "shippers_10709374")
@Entity
public class Shippers {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int shipperID;
    private long phone;
    private String shipperName;

}