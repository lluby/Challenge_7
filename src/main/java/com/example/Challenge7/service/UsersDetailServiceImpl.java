package com.example.Challenge7.service;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.model.UsersDetailsImpl;
import com.example.Challenge7.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UsersDetailServiceImpl implements UsersDetailService{
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(UserName)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username " + UserName));
        return UsersDetailsImpl.build(user);
    }

}
