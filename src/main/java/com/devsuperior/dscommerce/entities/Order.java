package com.devsuperior.dscommerce.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_order")
public class Order {

    @EqualsAndHashCode.Include
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @CreationTimestamp(source = SourceType.DB)
    @Column(columnDefinition = "timestamp without time zone")
    private Instant moment;

    @NonNull
    private OrderStatus status;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @NonNull
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

}
