package com.example.t2204msem4springshopping.controller_mvc;

import com.example.t2204msem4springshopping.dto.CategoryDTO;
import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.dto.ProductDTO;
import com.example.t2204msem4springshopping.dto.ProductEditDTO;
import com.example.t2204msem4springshopping.service.ICategoryService;
import com.example.t2204msem4springshopping.service.IProductService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductControllerMVC {
    private final IProductService productService;
    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductControllerMVC (
            IProductService productService,
            ICategoryService categoryService,
            ModelMapper modelMapper
    ) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public String getProduct(Model model) {
        List<ProductDTO> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("id", 1);
        model.addAttribute("name", "abc");

        return "product/index";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductCreateDTO());
        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "product/create";
    }

    @PostMapping("/create")
    public String submitCreateProduct(
            @ModelAttribute("product") @Valid ProductCreateDTO product,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            List<CategoryDTO> categories = categoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "product/create";
        }
        productService.createProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Optional<ProductDTO> product = productService.getProductById(id);
        if (product.isEmpty()) return null;

        model.addAttribute("product", modelMapper.map(product.get(), ProductEditDTO.class));
        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String submitUpdateProduct(
            @ModelAttribute("product") @Valid ProductEditDTO product,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) return "product/edit" + product.getId();

        productService.updateProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }
}
