package com.example.t2204msem4springshopping.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDTO {
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

}
