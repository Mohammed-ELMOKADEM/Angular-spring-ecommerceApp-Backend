package com.ecom.ecommerceApp.services;

import com.ecom.ecommerceApp.models.Product;
import com.ecom.ecommerceApp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    public ProductService(ProductRepository repo) {
        this.productRepository = repo;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).get();
    }

    public Product addProduct(Product p){return productRepository.save(p);}

    public Product updateProduct(Integer id, Product p){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product p1 = product.get();
            p1.setName(p.getName());
            p1.setPrice(p.getPrice());
            p1.setImage_path((p.getImage_path()));
            productRepository.save(p1);
            return p1;
        }
        else{
            return null;
        }
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsForOrderByIds(List<Integer> ids){
        return productRepository.findAllById(ids);
    }
}
