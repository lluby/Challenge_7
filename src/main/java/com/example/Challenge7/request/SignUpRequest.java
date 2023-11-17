package com.example.Challenge7.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String UserName;

    @NotBlank
    @Email
    private String EmailAddress;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 20)
    private String Password;
}
