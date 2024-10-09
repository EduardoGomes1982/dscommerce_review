package com.devsuperior.dscommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projection.UserRoleProjection;
import com.devsuperior.dscommerce.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDTO findByUserName(String username) {
        List<UserRoleProjection> result = repository.searchUserAndRolesByEmail(username);
        User user = new User();
        user.setName(result.get(0).getName());
        user.setEmail(result.get(0).getEmail());
        result.stream().forEach(p -> user.addRole(new Role(p.getId(), p.getAuthority())));
        return new UserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User result = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return result;
    }

    protected User authenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String username = jwt.getClaim("username");
        return (User) loadUserByUsername(username);
    }

    public UserDTO getMe() {
        return new UserDTO(authenticated());
    }

}
