package com.ecom.ecommerceApp.repositories;

import com.ecom.ecommerceApp.models.Cart;
import com.ecom.ecommerceApp.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{

    public List<ProductOrder> findProductOrdersByOrder(Cart order);
}
