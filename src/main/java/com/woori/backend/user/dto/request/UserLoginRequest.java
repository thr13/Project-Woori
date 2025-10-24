package com.woori.backend.user.dto.request;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String email;
    private String password;

    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static UserLoginRequest from(String email, String password) {
        return new UserLoginRequest(email, password);
    }
}
