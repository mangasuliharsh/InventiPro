package com.inventipro.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer productId
            ;
    @NotBlank(message = "Name Cannot be Empty")
    @Size(min = 2, max = 50,message = "Product name length must be in the range 2 to 50")
    private String productName;

    @NotBlank(message = "Category Id cannot be Empty")
    @Positive
    private Integer categoryId;

    @NotBlank(message = "Supplier Id Id cannot be Empty")
    @Positive
    private Integer supplierId;

    @NotBlank(message = "Quantity cannot be Empty")
    @Positive(message = "Quantity must be greater than Zero")
    private Integer quantityInStock;

    @NotBlank(message = "Quantity cannot be Empty")
    @Positive(message = "Price must be greater than Zero")
    private Double price;
}
