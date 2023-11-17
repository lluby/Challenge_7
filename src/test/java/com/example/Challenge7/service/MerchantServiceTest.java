package com.example.Challenge7.service;

import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.repository.MerchantRepository;
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
public class MerchantServiceTest {
    @Autowired
    MerchantService merchantService;
    MerchantServiceImpl merchantServiceImpl;

    @Autowired
    @SpyBean
    MerchantRepository merchantRepository;

    @Test
    void testGetAllMovie_spy_success() {
        Merchant merchant = Merchant.builder()
                .MerchantCode("Test")
                .MerchantName("Test")
                .MerchantLocation("Test")
                .open(true)
                .build();
        merchantRepository.save(merchant);

        Mockito.when(merchantRepository.findAll()).thenReturn(Arrays.asList(Merchant.builder()
                .MerchantCode("Test")
                .MerchantName("Test")
                .MerchantLocation("Test")
                .open(true)
                .build()));
        List<Merchant> merchantList = merchantService.getAllMerchant();
        Mockito.verify(merchantRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(0, merchantList.size());
    }
}
