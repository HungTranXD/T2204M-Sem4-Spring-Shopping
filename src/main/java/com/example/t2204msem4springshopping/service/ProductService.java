package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.dto.ProductDTO;
import com.example.t2204msem4springshopping.dto.ProductEditDTO;
import com.example.t2204msem4springshopping.entity.Category;
import com.example.t2204msem4springshopping.entity.Product;
import com.example.t2204msem4springshopping.repository.CategoryRepository;
import com.example.t2204msem4springshopping.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService (
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            ModelMapper modelMapper
    ) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public ProductDTO createProduct(ProductCreateDTO productCreateDTO) {
        Category category = categoryRepository.findById(productCreateDTO.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        System.out.println(category);
        Product product = modelMapper.map(productCreateDTO, Product.class);
        System.out.println(product.getId());
        product.setCategory(category);
        Product createdProduct = productRepository.save(product);
        return modelMapper.map(createdProduct, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> getAllProducts(String search, String sort, Pageable pageable) {
        Page<Product> products;

        if (search != null && !search.isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            products = productRepository.findAll(pageable);
        }
        return products.map(product -> modelMapper.map(product, ProductDTO.class));
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductDTO.class));
    }

    @Override
    public ProductDTO updateProduct(ProductEditDTO productEditDTO) {
        Product product = modelMapper.map(productEditDTO, Product.class);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
