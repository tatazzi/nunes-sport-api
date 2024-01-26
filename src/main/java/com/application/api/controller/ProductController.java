package com.application.api.controller;

import com.application.api.dtos.EditProductDto;
import com.application.api.dtos.PaginatedProductDto;
import com.application.api.dtos.RegisterProductDto;
import com.application.api.model.Product;
import com.application.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public PaginatedProductDto getProducts(@RequestParam(value = "page", defaultValue = "0") int page) {
        return productService.getProducts(page);
    }

    @PostMapping("/registerProduct")
    public ResponseEntity<Object> registerProduct(@RequestBody RegisterProductDto data) {
        try {
            Product newProduct = new Product(data);
            productService.createProduct(newProduct);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editProduct/{code}")
    public ResponseEntity<Object> updateProduct(@PathVariable String code, @RequestBody EditProductDto product) {
        Product updatedProduct = productService.editProduct(code, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/deleteProduct/{code}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String code) {
        Product product = productService.deleteProduct(code);
        return ResponseEntity.ok(product);
    }
}
