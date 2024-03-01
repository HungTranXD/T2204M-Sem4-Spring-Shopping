//package com.example.t2204msem4springshopping.service;
//
//import com.example.t2204msem4springshopping.dto.ProductDTO;
//import com.example.t2204msem4springshopping.entity.Product;
//import com.example.t2204msem4springshopping.repository.ProductRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTests {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
////    @Test
////    public void ProductService_CreateProduct_ReturnProductDTO() {
////        // Arrange
////        Product product = Product.builder()
////                .name("Iphone 14")
////                .price(1200)
////                .quantity(100)
////                .build();
////        ProductDTO productDTO = ProductDTO.builder()
////                .name("Iphone 14")
////                .price(1200)
////                .quantity(100)
////                .build();
////
////        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
////
////        // Act test
////        ProductDTO savedProduct = productService.createProduct(product);
////
////        // Assert
////        Assertions.assertThat(savedProduct).isNotNull();
////        Assertions.assertThat(savedProduct.getName()).isEqualTo(product.getName());
////    }
//}
