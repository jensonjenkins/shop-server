package com.idp.server.dto;

import com.idp.server.user.UserEntity;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
    private UserEntity user;

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponseDto(String accessToken, UserEntity user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
