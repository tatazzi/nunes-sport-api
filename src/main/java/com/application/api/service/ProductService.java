package com.application.api.service;

import com.application.api.dtos.EditProductDto;
import com.application.api.model.Product;
import com.application.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {

            try {
                if(productRepository.findByCode(product.getCode())!=null){
                throw new Exception("Codigo do produto ja registrado");
                } productRepository.save(product);
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
