package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductDTO createProduct(ProductCreateDTO productCreateDTO);

    Page<ProductDTO> getAllProducts(String search, String sort, Pageable pageable);

    Optional<ProductDTO> getProductById(Long id);

    ProductDTO updateProduct(ProductEditDTO productEditDTO);

    void deleteProduct(Long id);
}
