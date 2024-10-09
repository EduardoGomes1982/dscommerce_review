package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
public class RoleDTO {

    @ToString.Exclude
    private final Long id;

    private final String authority;

    public RoleDTO(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }
}
