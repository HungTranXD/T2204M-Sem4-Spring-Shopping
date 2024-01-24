package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.dto.CategoryCreateDTO;
import com.example.t2204msem4springshopping.dto.CategoryDTO;
import com.example.t2204msem4springshopping.dto.CategoryEditDTO;
import com.example.t2204msem4springshopping.entity.Category;
import com.example.t2204msem4springshopping.entity.User;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    CategoryDTO createCategory(CategoryCreateDTO categoryCreateDTO);

    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long id);

    CategoryDTO updateCategory(CategoryEditDTO categoryEditDTO);

    void deleteCategory(Long id);
}
