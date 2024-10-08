package com.devsuperior.dscommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projection.UserRoleProjection;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"roles"})
    User findByEmail(String email);

    @Query("select new com.devsuperior.dscommerce.projection.UserRoleProjection(u.name, u.email, r.id, r.authority) from User u join u.roles r where u.email=:email")
    List<UserRoleProjection> searchUserAndRolesByEmail(String email);

}
