package com.example.t2204msem4springshopping.dto;

import jakarta.validation.constraints.*;

public class ProductEditDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 225, message = "Name must be lest than 255 characters")
    private String name;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0", message = "Price must be greater than or equal to 0")
    private double price;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private int quantity;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
