package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomError {

    private final Instant timestamp;
    private final Integer status;
    private final String error;
    private final String path;

}
