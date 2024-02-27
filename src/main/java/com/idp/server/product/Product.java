package com.idp.server.product;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "product_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDate createdAt;
    private Integer categoryId;

    public Product(){};
    public Product(String name,
                   String description,
                   Double price,
                   LocalDate createdAt,
                   Integer categoryId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
