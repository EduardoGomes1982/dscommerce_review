package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClientDTO {

    private final Long id;
    private final String name;

    public ClientDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

}
