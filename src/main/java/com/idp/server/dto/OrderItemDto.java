package com.idp.server.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long sessionId;
    private Long productId;
    private Integer quantity;

    public Long getSessionId() {
        return sessionId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
