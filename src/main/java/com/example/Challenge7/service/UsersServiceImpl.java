package com.example.Challenge7.service;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository usersRepository;
    @Override
    public Users addUsers(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void deleteUsers(String UserId) {
        usersRepository.deleteById((UserId));
    }

    @Override
    public Users updateUsers(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUsersDetail(String UserId) {
        log.info("Getting product detail info of {}", UserId);
        return Optional.ofNullable(usersRepository.findById((UserId)))
                .map(users->Users.builder()
                        .userName(users.get().getUserName())
                        .email(users.get().getEmail())
                        .Password(users.get().getPassword())
                        .build())
                .orElse(null);
    }
}
