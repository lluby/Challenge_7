package com.example.Challenge7.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtResponse {
    private String token;
    private String type = "Bearer ";
    private String UserId;
    private String UserName;
    private String EmailAddress;
    private List<String> roles;

    public JwtResponse(String token, String UserId, String UserName, String EmailAddress, List<String> roles) {
        this.token = token;
        this.UserId = UserId;
        this.UserName = UserName;
        this.EmailAddress = EmailAddress;
        this.roles = roles;
    }
}
