package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderDTO {

    private final Long id;
    private final Instant moment;
    private final OrderStatus status;
    private final ClientDTO client;
    private final PaymentDTO payment;

    @NotEmpty(message = "At least one item is required")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment()) == null ? null : new PaymentDTO(entity.getPayment());
        entity.getItems().forEach(i -> items.add(new OrderItemDTO(i)));
    }

    public Double getAmount() {
        return items.stream().mapToDouble(OrderItemDTO::getSubTotal).sum();
    }

}
