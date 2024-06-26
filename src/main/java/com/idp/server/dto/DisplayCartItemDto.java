package com.idp.server.dto;

import lombok.Data;

@Data
public class DisplayCartItemDto {
    private int quantity;
    private String name;
    private double price;
    private String imageLink;

    private Long productId;

    public DisplayCartItemDto(int quantity, String name, double price, String imageLink, Long productId) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getImageLink() {
        return imageLink;
    }
}
