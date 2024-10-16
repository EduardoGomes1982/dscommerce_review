package com.devsuperior.dscommerce.dto;

import java.util.ArrayList;
import java.util.List;
import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class ProductDTO {

    private final Long id;

    @NotBlank(message = "Required field")
    @Size(min = 3, max = 80, message = "The name must have between 3 and 80 characters")
    private final String name;

    @NotNull(message = "Required field")
    @Positive(message = "The price must be greater than zero")
    private final Double price;

    @NotBlank(message = "Required field")
    @Size(min = 10, message = "The description must have at least 10 characters")
    private final String description;

    private final String imageUrl;

    @NotEmpty(message = "At least one category is required")
    @Setter(AccessLevel.NONE)
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUrl = entity.getImageUrl();
        categories = entity.getCategories().stream().map(CategoryDTO::new).toList();
    }

}
