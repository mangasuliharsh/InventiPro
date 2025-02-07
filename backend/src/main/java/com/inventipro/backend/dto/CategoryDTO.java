package com.inventipro.backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Integer categoryId;

    @NotBlank(message = "Category name cannot be empty")
    @Size(min = 2,max = 30,message = "Category name length must be in the range 2 to 30")
    private String categoryName;

    @NotBlank(message = "Category description must not be empty")
    @Size(min = 2,max = 150,message = "Category description length must be in the range 2 to 150")
    private String description;
}