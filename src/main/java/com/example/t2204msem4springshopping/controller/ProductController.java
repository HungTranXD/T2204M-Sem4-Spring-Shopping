package com.example.t2204msem4springshopping.controller;

import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.dto.ProductDTO;
import com.example.t2204msem4springshopping.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductDTO> getAllProducts(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sort", defaultValue = "default") String sort,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getAllProducts(search, sort, pageable);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        ProductDTO productDTO = productService.createProduct(productCreateDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
}
