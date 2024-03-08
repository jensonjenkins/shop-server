package com.idp.server.cartItem;

import jakarta.persistence.*;

@Entity
@Table
public class CartItem {
    @Id
    @SequenceGenerator(
            name = "cart_item_sequence",
            sequenceName = "cart_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_item_sequence"
    )
    private Long id;
    private Long sessionId;
    private Long productId;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Long sessionId, Long productId, int quantity) {
        this.sessionId = sessionId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
