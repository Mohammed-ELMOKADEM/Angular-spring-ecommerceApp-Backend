package com.ecom.ecommerceApp.repositories;

import com.ecom.ecommerceApp.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    public Optional<Cart> getCartByIdClient(Integer id);
}
