package com.example.Challenge7.controller;

import com.example.Challenge7.model.Users;
import com.example.Challenge7.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/users")
@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Api to get all merchant")
    public List<Users> getUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping(value = "add-users")
    @Secured(value = "ROLE_ADMIN")
    public ResponseEntity addUsers(@RequestBody Users users){
        usersService.addUsers(users.builder()
                        .UserId(users.getUserId())
                        .userName(users.getUserName())
                        .email(users.getEmail())
                        .Password(users.getPassword())
                .build());
        return ResponseEntity.ok("Users added successfully");
    }
    @PostMapping(value = "update-users")
    @Secured(value = "ROLE_USER")
    public ResponseEntity updateUsers(@RequestBody Users users) {
        Users updateUsers = usersService.updateUsers(users);
        if (updateUsers != null) {
            return new ResponseEntity<>(updateUsers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to update Users", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/detail")
    @Operation(summary = "Getting detail of one user by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user found"),
            @ApiResponse(responseCode = "404", description = "Inputted user id not found")
    })

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{UserId}")
    @Secured(value = "ROLE_USER")
    public String deleteUsers(@PathVariable("UserId") String UserId) {
        usersService.deleteUsers(UserId);
        return "Delete User " + UserId + " success!";
    }

    @GetMapping("/detail/{UserId}")
    public ResponseEntity getUsersDetail(@PathVariable String UserId) {
        Users users = usersService.getUsersDetail(UserId);
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
