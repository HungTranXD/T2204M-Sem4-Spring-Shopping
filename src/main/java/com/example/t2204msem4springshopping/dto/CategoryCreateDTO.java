package com.example.t2204msem4springshopping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryCreateDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be less than 100 character")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
