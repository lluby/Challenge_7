package com.example.Challenge7.service;

import com.example.Challenge7.model.Users;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public interface LoginRegisterService {
    public void registerOauth2User(Authentication authentication);
    public Optional<Users> loginOauth2User(Authentication authentication);
}
