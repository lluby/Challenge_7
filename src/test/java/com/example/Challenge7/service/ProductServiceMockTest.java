package com.example.Challenge7.service;

import com.example.Challenge7.model.Product;
import com.example.Challenge7.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductServiceMockTest {
    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    void getProductDetailTest() {
        Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(Product.builder()
                .ProductCode("Test")
                .ProductName("Test")
                .price(Long.valueOf(100))
                .build()));
        Product product = productService.getProductDetails("Test");

        Mockito.verify(productRepository, Mockito.times(1)).findById(Mockito.anyString());

        Assertions.assertNotNull(product);
    }
}
