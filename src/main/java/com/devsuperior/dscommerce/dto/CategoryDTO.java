package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CategoryDTO {

    private final Long id;

    @NotBlank(message = "Required field")
    @Size(min = 3, max = 20, message = "The name must have between 3 and 20 characters")
    private final String name;

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

}
