package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
