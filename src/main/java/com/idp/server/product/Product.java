package com.idp.server.product;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDate createdAt;
    private String categoryId;
    private String imageLink;
    private Integer availability;

    public Product() {
    }

    public Product(String name,
                   String description,
                   Double price,
                   LocalDate createdAt,
                   String categoryId, String imageLink,
                   Integer availability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
        this.imageLink = imageLink;
        this.availability = availability;
    }

    public Long getId() {
        return this.id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
