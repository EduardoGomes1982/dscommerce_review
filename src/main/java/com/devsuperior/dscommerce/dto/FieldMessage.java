package com.devsuperior.dscommerce.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FieldMessage {

    private final String fieldName;
    private final String message;

}
