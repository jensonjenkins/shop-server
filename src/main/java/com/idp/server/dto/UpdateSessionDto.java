package com.idp.server.dto;

import lombok.Data;

@Data
public class UpdateSessionDto {
    private Long sessionId;
    private double price;

    public Long getSessionId() {
        return sessionId;
    }

    public double getPrice() {
        return price;
    }
}
