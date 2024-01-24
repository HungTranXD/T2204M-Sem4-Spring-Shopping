package com.example.t2204msem4springshopping.controller;

import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.dto.ProductDTO;
import com.example.t2204msem4springshopping.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController (IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        ProductDTO productDTO = productService.createProduct(productCreateDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
}
