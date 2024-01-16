package com.ecom.ecommerceApp.services;

import com.ecom.ecommerceApp.models.Cart;
import com.ecom.ecommerceApp.models.Product;
import com.ecom.ecommerceApp.models.ProductOrder;
import com.ecom.ecommerceApp.models.User;
import com.ecom.ecommerceApp.repositories.CartRepository;
import com.ecom.ecommerceApp.repositories.ProductOrderRepository;
import com.ecom.ecommerceApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private CartRepository cartRepository;
    private ProductOrderRepository poRepository;
    private ProductRepository productRepository;
    public OrderService(CartRepository cartRepository, ProductOrderRepository poRepository, ProductRepository productRepository){
        this.cartRepository = cartRepository;
        this.poRepository = poRepository;
        this.productRepository = productRepository;
    }

    public ProductOrder addOrder(Integer idUser, Integer idProduct){
        Optional<Cart> cartOptional = cartRepository.getCartByIdClient(idUser);
        Cart cart = new Cart();
        if(!cartOptional.isPresent()){
            cart.setIdClient(idUser);
            cart = cartRepository.save(cart);
        }
        else {
            cart = cartOptional.get();
        }
        ProductOrder PO = new ProductOrder();
        PO.setOrder(cart);
        PO.setProduct(productRepository.findById(idProduct).get());
        return poRepository.save(PO);
    }

    public List<ProductOrder> getOrdersByUser(Integer idUser){
        Optional<Cart> optionalCart = cartRepository.getCartByIdClient(idUser);
        Cart cart = new Cart();
        if(optionalCart.isPresent()){
            cart = optionalCart.get();
            return poRepository.findProductOrdersByOrder(cart);
        }
        else{
            return null;
        }
    }

}
