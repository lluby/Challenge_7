package com.example.Challenge7.service;

import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.repository.MerchantRepository;
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
public class MerchantServiceMockTest {
    @InjectMocks
    MerchantService merchantService;

    @Mock
    MerchantRepository merchantRepository;

    @Test
    void getMerchantDetailTest() {
        Mockito.when(merchantRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(Merchant.builder()
                .MerchantCode("Test")
                .MerchantName("Test")
                .MerchantLocation("Test")
                .open(true)
                .build()));
        Merchant merchant = merchantService.getMerchantDetail("test");

        Mockito.verify(merchantRepository, Mockito.times(1)).findById(Mockito.anyString());

        Assertions.assertNotNull(merchant);
    }

}
