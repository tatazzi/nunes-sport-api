package com.application.api.repository;

import com.application.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
 List<Product> findByName(String name);

 Product findByCode(String code);
}
