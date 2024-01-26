package com.application.api.service;

import com.application.api.dtos.EditProductDto;
import com.application.api.dtos.PaginatedProductDto;
import com.application.api.model.Product;
import com.application.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public PaginatedProductDto getProducts(int page) {
        int pageSize = 5;
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepository.findAll(pageRequest);

        PaginatedProductDto response = new PaginatedProductDto();
        response.setProducts(productPage.getContent());
        response.setCurrentPage(productPage.getNumber());
        response.setTotalItems((int) productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());

        return response;
    }

    public void createProduct(Product product) {

        try {
            if (productRepository.findByCode(product.getCode()) != null) {
                throw new Exception("Codigo do produce ja registrado");
            }
            productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Product editProduct(String code, EditProductDto productDto) {
        Product productToUpdate = productRepository.findByCode(code);
        if (productToUpdate != null) {
            productToUpdate.setName(productDto.name());
            productToUpdate.setDescription(productDto.description());
            productToUpdate.setPrice(productDto.price());
            return productRepository.save(productToUpdate);
        } else {
            return null;
        }
    }

    public Product deleteProduct(String code) {
        Product productToDelete = productRepository.findByCode(code);
        if (productToDelete != null) {
            productRepository.deleteById(productToDelete.getCode());
            return productToDelete;
        } else {
            return null;
        }
    }


}
