package com.idp.server.orderItem;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItem {
    @Id
    @SequenceGenerator(name = "order_item_sequence", sequenceName = "order_item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_sequence")
    private Long id;
    private Long sessionId;
    private Integer quantity;
    private Long productId;
    private Long orderId;

    public OrderItem() {
    }

    public OrderItem(Long sessionId, Integer quantity, Long productId, Long orderId) {
        this.sessionId = sessionId;
        this.quantity = quantity;
        this.productId = productId;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
