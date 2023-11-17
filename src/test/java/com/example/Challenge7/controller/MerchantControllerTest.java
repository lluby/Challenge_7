package com.example.Challenge7.controller;

import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.service.MerchantService;
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
public class MerchantControllerTest {
    @InjectMocks
    MerchantController merchantController;
    @Mock
    MerchantService merchantService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void getAllMerchant_test_success() {
        Mockito.when(merchantService.getAllMerchant()).thenReturn(Arrays.asList(Merchant.builder()
                .MerchantCode("Test")
                .MerchantName("Test")
                .MerchantLocation("Test")
                .open(true)
                .build()));
        ResponseEntity<List<Merchant>> merchant = merchantController.getMerchantDetail("Test");

        Mockito.verify(merchantService).getAllMerchant();
        Assertions Assertions = null;
        Assertions.assertEquals(0, merchantController.getMerchant());
    }
        @Test
        void getAllMerchantApi() throws Exception {
            Mockito.when(merchantService.getAllMerchant()).thenReturn(Arrays.asList(Merchant.builder()
                    .MerchantCode("Test")
                    .MerchantName("Test")
                    .MerchantLocation("Test")
                    .open(true)
                    .build()));

            mockMvc.perform(MockMvcRequestBuilders.post("/get-all-merchant").with(new RequestPostProcessor() {
                        @Override
                        public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                            return null;
                        }
                    }))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }

}
