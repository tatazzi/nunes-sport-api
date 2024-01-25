package com.application.api.dtos;

import java.math.BigDecimal;

public record EditProductDto(String name, String description, BigDecimal price) {
}
