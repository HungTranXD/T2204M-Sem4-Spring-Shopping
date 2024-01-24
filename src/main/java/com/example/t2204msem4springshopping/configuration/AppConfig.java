package com.example.t2204msem4springshopping.configuration;

import com.example.t2204msem4springshopping.dto.ProductCreateDTO;
import com.example.t2204msem4springshopping.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(ProductCreateDTO.class, Product.class)
                .addMappings(mapper -> mapper.skip(Product::setId));

        return modelMapper;
    }

}
