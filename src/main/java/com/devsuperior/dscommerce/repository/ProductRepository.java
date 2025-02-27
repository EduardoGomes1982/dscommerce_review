package com.devsuperior.dscommerce.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join fetch p.categories c where p.id = :id")
    Optional<Product> findByIdFetchCategories(Long id);

    @Query("select p from Product p where upper(p.name) like upper(concat('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);

}
