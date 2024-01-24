package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.dto.CategoryCreateDTO;
import com.example.t2204msem4springshopping.dto.CategoryDTO;
import com.example.t2204msem4springshopping.dto.CategoryEditDTO;
import com.example.t2204msem4springshopping.entity.Category;
import com.example.t2204msem4springshopping.entity.User;
import com.example.t2204msem4springshopping.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService (CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryCreateDTO categoryCreateDTO) {
        Category category = modelMapper.map(categoryCreateDTO, Category.class);
        Category createdCategory = categoryRepository.save(category);
        return modelMapper.map(createdCategory, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> modelMapper.map(category, CategoryDTO.class));
    }

    @Override
    public CategoryDTO updateCategory(CategoryEditDTO categoryEditDTO) {
        Category category = modelMapper.map(categoryEditDTO, Category.class);
        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
