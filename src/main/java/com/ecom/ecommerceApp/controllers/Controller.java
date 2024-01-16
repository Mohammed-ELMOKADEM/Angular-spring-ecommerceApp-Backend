package com.ecom.ecommerceApp.controllers;

import com.ecom.ecommerceApp.models.*;
import com.ecom.ecommerceApp.services.OrderService;
import com.ecom.ecommerceApp.services.ProductService;
import com.ecom.ecommerceApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
@CrossOrigin("http://localhost:4200/")
public class Controller {

    private ProductService productService;
    private UserService userService;
    private OrderService orderService;
    public Controller(ProductService productService, UserService userService, OrderService orderService) {
        this.productService = productService;
        this.userService =userService;
        this.orderService = orderService;
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("user/{email}")
    public User getUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("newProduct")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("updateProduct/{idProduct}")
    public Product updateProduct(
            @PathVariable Integer idProduct,
            @RequestBody Product updatedProduct){
        return productService.updateProduct(idProduct,updatedProduct);
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

    @PostMapping("addOrder")
    public ProductOrder addOrder(@RequestBody OrderRequest orderRequest){
        Integer idClient = orderRequest.getUserId();
        Integer idProduct = orderRequest.getIdProduct();
        return orderService.addOrder(idClient, idProduct);
    }

    @GetMapping("getOrders/{idUser}")
    public List<ProductOrder> getOrdersByUser(@PathVariable Integer idUser){
        return orderService.getOrdersByUser(idUser);
    }

    @GetMapping("getOrdersProducts/{Ids}")
    public List<Product> getProductsForOrderByIds(@PathVariable List<Integer> Ids){
        return productService.getProductsForOrderByIds(Ids);
    }
}
