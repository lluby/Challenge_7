package com.example.Challenge7.service;

import com.example.Challenge7.model.Order;
import com.example.Challenge7.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProduct();
    Product updateProduct(Product product);
    void deleteProduct(String ProductCode);
    Product getProductDetails(String ProductCode);
}
