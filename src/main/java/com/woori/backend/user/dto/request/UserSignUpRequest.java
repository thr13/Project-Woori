package com.woori.backend.user.dto.request;

import com.woori.backend.global.common.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserSignUpRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotNull
    private Role role;

    public UserSignUpRequest(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public static UserSignUpRequest from(String email, String password, String name, Role role) {
        return new UserSignUpRequest(email, password, name, role);
    }
}
