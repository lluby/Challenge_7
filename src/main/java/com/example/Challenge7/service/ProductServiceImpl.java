package com.example.Challenge7.service;

import ch.qos.logback.classic.Logger;
import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.model.Product;
import com.example.Challenge7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    private Logger log;

    @Async
    @Transactional
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String ProductCode) {
        productRepository.deleteById(ProductCode);
    }

    @Transactional(readOnly = true)
    @Override
    public Product getProductDetails(String ProductCode) {
        log.info("Getting product detail info of {}", ProductCode);
        return Optional.ofNullable(productRepository.findById(ProductCode))
                .map(product->Product.builder()
                        .ProductCode(product.get().getProductCode())
                        .ProductName(product.get().getProductName())
                        .price(product.get().getPrice())
                        .merchant(product.get().getMerchant())
                        .build())
                .orElse(null);
    }
}
