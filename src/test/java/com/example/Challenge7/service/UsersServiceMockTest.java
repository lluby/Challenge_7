package com.example.Challenge7.service;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersServiceMockTest {
    @InjectMocks
    UsersService usersService;

    @Mock
    UsersRepository usersRepository;

    @Test
    void getUsersDetailTest() {
        Mockito.when(usersRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(Users.builder()
                .UserId("Test")
                .userName("Test")
                .email("Test")
                .Password("Test")
                .build()));
        Users users = usersService.getUsersDetail("Test");

        Mockito.verify(usersRepository, Mockito.times(1)).findById(Mockito.anyString());

        Assertions.assertNotNull(users);
    }
}
