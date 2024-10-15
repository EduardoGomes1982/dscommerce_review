package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import com.devsuperior.dscommerce.entities.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PaymentDTO {

    private final Long id;
    private final Instant moment;

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

}
