package com.ecom.ecommerceApp.repositories;

import com.ecom.ecommerceApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
