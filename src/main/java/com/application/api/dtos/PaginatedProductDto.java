package com.application.api.dtos;

import com.application.api.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PaginatedProductDto {
    // Getters e Setters
    private List<Product> products;
    private int currentPage;
    private int totalItems;
    private int totalPages;
    public PaginatedProductDto() {
    }

    public PaginatedProductDto(List<Product> products, int currentPage, int totalItems, int totalPages) {
        this.products = products;
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

}
