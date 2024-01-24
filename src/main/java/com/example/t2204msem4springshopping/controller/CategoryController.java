package com.example.t2204msem4springshopping.controller;

import com.example.t2204msem4springshopping.dto.CategoryCreateDTO;
import com.example.t2204msem4springshopping.dto.CategoryDTO;
import com.example.t2204msem4springshopping.dto.CategoryEditDTO;
import com.example.t2204msem4springshopping.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController (ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(categoryDTO -> ResponseEntity.ok().body(categoryDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryCreateDTO categoryCreateDTO) {
        CategoryDTO createdCategory = categoryService.createCategory(categoryCreateDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryEditDTO categoryEditDTO) {
        if (!id.equals(categoryEditDTO.getId())) {
            return ResponseEntity.badRequest().body("ID in URL and DTO body do not match");
        }

        CategoryDTO updatedCategory = categoryService.updateCategory(categoryEditDTO);
        return ResponseEntity.ok().body(updatedCategory);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (categoryService.getCategoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
