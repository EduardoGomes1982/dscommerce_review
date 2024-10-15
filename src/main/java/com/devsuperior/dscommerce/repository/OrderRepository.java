package com.devsuperior.dscommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @SuppressWarnings("null")
    @EntityGraph(attributePaths = {"items.id.product", "client", "payment"},
            type = EntityGraph.EntityGraphType.LOAD)
    Optional<Order> findById(Long id);

}
