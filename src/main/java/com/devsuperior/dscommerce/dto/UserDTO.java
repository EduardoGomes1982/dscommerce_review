package com.devsuperior.dscommerce.dto;

import java.util.ArrayList;
import java.util.List;
import com.devsuperior.dscommerce.entities.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class UserDTO {

    private final String name;
    private final String email;

    @Setter(AccessLevel.NONE)
    private List<RoleDTO> roles = new ArrayList<>();

    public UserDTO(User user) {
        name = user.getName();
        email = user.getEmail();
        roles = user.getRoles().stream().map(RoleDTO::new).toList();
    }
}
