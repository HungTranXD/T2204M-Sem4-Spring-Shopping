package com.example.t2204msem4springshopping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryEditDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 5, message = "Name must be less than 100 character")
    private String name;

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
}
