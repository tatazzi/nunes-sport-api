package com.application.api.model;

import com.application.api.dtos.RegisterProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table()
@Entity(name="products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @Column(unique = true)
    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    public Product(RegisterProductDto registerProductDto){
        this.code=registerProductDto.code();
        this.name=registerProductDto.name();
        this.description=registerProductDto.description();
        this.price=registerProductDto.price();
    }
}
