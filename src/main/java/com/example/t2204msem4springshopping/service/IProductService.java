package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.dto.*;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductDTO createProduct(ProductCreateDTO productCreateDTO);

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Long id);

    ProductDTO updateProduct(ProductEditDTO productEditDTO);

    void deleteProduct(Long id);
}
