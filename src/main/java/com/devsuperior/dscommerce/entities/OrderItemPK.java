package com.devsuperior.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OrderItemPK {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
