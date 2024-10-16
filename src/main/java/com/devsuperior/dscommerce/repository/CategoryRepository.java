package com.devsuperior.dscommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
