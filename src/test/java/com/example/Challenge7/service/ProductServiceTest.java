package com.example.Challenge7.service;

import com.example.Challenge7.model.Product;
import com.example.Challenge7.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    ProductServiceImpl productServiceImpl;

    @Autowired
    @SpyBean
    ProductRepository productRepository;

    @Test
    void testGetAllProduct_spy_success() {
        Product product = Product.builder()
                .ProductCode("Test")
                .ProductName("Test")
                .price(Long.valueOf(100))
                .build();
        productRepository.save(product);

        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(Product.builder()
                .ProductCode("Test")
                .ProductName("Test")
                .price(Long.valueOf(100))
                .build()));
        List<Product> productList = productService.getAllProduct();
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(0, productList.size());
    }
}
