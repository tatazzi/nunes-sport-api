package com.application.api.dtos;

import java.math.BigDecimal;

public record RegisterProductDto(String code,String name,String description,BigDecimal price) {
}
