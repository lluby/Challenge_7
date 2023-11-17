package com.example.Challenge7.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDetailService {
    @Bean
    UserDetails loadUserByUsername(String UserName);
}
