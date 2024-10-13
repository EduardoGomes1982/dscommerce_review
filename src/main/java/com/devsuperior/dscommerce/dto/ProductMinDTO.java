package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductMinDTO {

    private final Long id;

    @NotBlank(message = "Required field")
    @Size(min = 3, max = 80, message = "The name must have between 3 and 80 characters")
    private final String name;

    @Positive(message = "The price must be greater than zero")
    private final Double price;

    private final String imageUrl;

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imageUrl = entity.getImageUrl();
    }

}
