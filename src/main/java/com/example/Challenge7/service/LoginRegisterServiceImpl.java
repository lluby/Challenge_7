package com.example.Challenge7.service;

import com.example.Challenge7.enumeration.ERole;
import com.example.Challenge7.model.Roles;
import com.example.Challenge7.model.Users;
import com.example.Challenge7.repository.RoleRepository;
import com.example.Challenge7.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService{

    @Autowired
    UsersRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void registerOauth2User(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        Set<Roles> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(ERole.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found")));
        userRepository.save(Users.builder()
                .Password(oAuth2User.getAttributes().get("id").toString())
                .provider("github")
                .roles(roles)
                .userName(oAuth2User.getAttributes().get("login").toString())
                .build());
    }

    @Override
    public Optional<Users> loginOauth2User(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        return userRepository.findByuserName(oAuth2User.getAttributes().get("login").toString());
    }
}
