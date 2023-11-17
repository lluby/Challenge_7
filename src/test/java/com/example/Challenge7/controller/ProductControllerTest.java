package com.example.Challenge7.controller;

import com.example.Challenge7.model.Product;
import com.example.Challenge7.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {
    @InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void getAllMerchant_test_success() {
        Mockito.when(productService.getAllProduct()).thenReturn(Arrays.asList(Product.builder()
                .ProductCode("Test")
                .ProductName("Test")
                .price(Long.valueOf(100))
                .build()));
        ResponseEntity<List<Product>> product = productController.getProductDetail("Test");

        Mockito.verify(productService).getAllProduct();
        Assertions Assertions = null;
        Assertions.assertEquals(0,productController.getProduct());
    }
    @Test
    void getAllProductApi() throws Exception {
        Mockito.when(productController.getProduct()).thenReturn(Arrays.asList(Product.builder()
                .ProductCode("Test")
                .ProductName("Test")
                .price(Long.valueOf(100))
                .build()));

        mockMvc.perform(MockMvcRequestBuilders.post("/get-all-product").with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                        return null;
                    }
                }))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}


