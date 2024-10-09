package com.devsuperior.dscommerce.dto;

import java.time.LocalDate;
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

    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final LocalDate birthdate;

    @Setter(AccessLevel.NONE)
    private List<RoleDTO> roles = new ArrayList<>();

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        phone = user.getPhone();
        birthdate = user.getBirthdate();
        roles = user.getRoles().stream().map(RoleDTO::new).toList();
    }
}
