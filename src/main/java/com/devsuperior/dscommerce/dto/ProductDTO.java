package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Double price;

    @NonNull
    private String description;

    @NonNull
    private String imageUrl;

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUrl = entity.getImageUrl();
    }

}
