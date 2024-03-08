package com.idp.server.dto;

import lombok.Data;

@Data
public class DisplayCartItemDto {
    private int quantity;
    private String name;
    private double price;
    private String imageLink;

    public DisplayCartItemDto(int quantity, String name, double price, String imageLink) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
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

    public String getImageLink() {
        return imageLink;
    }
}
