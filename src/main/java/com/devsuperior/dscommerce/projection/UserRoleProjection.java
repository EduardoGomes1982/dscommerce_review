package com.devsuperior.dscommerce.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRoleProjection {

    private final String name;
    private final String email;
    private final Long id;
    private final String authority;

}
