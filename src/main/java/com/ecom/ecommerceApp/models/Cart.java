package com.ecom.ecommerceApp.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCart;
    private Integer idClient;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}
