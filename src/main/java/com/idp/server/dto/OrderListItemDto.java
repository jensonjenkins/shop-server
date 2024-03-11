package com.idp.server.dto;

import lombok.Data;

@Data
public class OrderListItemDto {
    private int quantity;
    private String name;
    private double price;
    private String imageLink;

    private Long orderId;

    public OrderListItemDto(int quantity, String name, double price, String imageLink, Long orderId) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.orderId = orderId;
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

    public Long getOrderId() {
        return orderId;
    }

    public String getImageLink() {
        return imageLink;
    }

}
