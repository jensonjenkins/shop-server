package com.idp.server.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long sessionId;
    private Long productId;
    private int quantity;

    public Long getSessionId() {
        return sessionId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
