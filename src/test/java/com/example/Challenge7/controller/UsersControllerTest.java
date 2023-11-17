package com.example.Challenge7.controller;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.service.UsersService;
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
public class UsersControllerTest {
    @InjectMocks
    UsersController usersController;
    @Mock
    UsersService usersService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void getAllUsers_test_success() {
        Mockito.when(usersService.getAllUsers()).thenReturn(Arrays.asList(Users.builder()
                .UserId("Test")
                .userName("Test")
                .email("Test")
                .Password("Test")
                .build()));
        ResponseEntity<List<Users>> users = usersController.getUsersDetail("Test");

        Mockito.verify(usersService).getAllUsers();
        Assertions Assertions = null;
        Assertions.assertEquals(0,usersController.getUsers());
    }
    @Test
    void getAllUsersApi() throws Exception {
        Mockito.when(usersController.getUsers()).thenReturn(Arrays.asList(Users.builder()
                .UserId("Test")
                .userName("Test")
                .email("Test")
                .Password("Test")
                .build()));

        mockMvc.perform(MockMvcRequestBuilders.post("/get-all-users").with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                        return null;
                    }
                }))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
