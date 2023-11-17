package com.example.Challenge7.service;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Arrays;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class UsersServiceTest {
    @Autowired
    UsersService usersService;
    UsersServiceImpl usersServiceImpl;

    @Autowired
    @SpyBean
    UsersRepository usersRepository;

    @Test
    void testGetAllUsers_spy_success() {
        Users users = Users.builder()
                .UserId("Test")
                .userName("Test")
                .email("Test")
                .Password("Test")
                .build();
        usersRepository.save(users);

        Mockito.when(usersRepository.findAll()).thenReturn(Arrays.asList(Users.builder()
                .UserId("Test")
                .userName("Test")
                .email("Test")
                .Password("Test")
                .build()));
        List<Users> usersList = usersService.getAllUsers();
        Mockito.verify(usersRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(0, usersList.size());
    }
}
