package com.example.t2204msem4springshopping.controller_mvc;

import com.example.t2204msem4springshopping.dto.CategoryDTO;
import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.dto.ProductDTO;
import com.example.t2204msem4springshopping.service.ICategoryService;
import com.example.t2204msem4springshopping.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControllerMVC {
    private final IProductService productService;
    private final ICategoryService categoryService;

    @Autowired
    public ProductControllerMVC (
            IProductService productService,
            ICategoryService categoryService
    ) {
        this.productService = productService;
        this.categoryService = categoryService;
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
    public String submitCreateProduct(@ModelAttribute("product") @Valid ProductCreateDTO product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(product);
            return "product/create";
        }
        productService.createProduct(product);
        return "redirect:/product/list";
    }
}
