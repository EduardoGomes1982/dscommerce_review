package com.devsuperior.dscommerce.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {

    @EqualsAndHashCode.Include
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String description;

    @NonNull
    private Double price;

    @NonNull
    private String imageUrl;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

}
