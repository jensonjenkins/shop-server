package com.idp.server.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public CharSequence getPassword() {
        return password;
    }
}
