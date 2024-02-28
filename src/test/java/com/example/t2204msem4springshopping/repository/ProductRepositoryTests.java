package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.Category;
import com.example.t2204msem4springshopping.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void ProductRepository_SaveAll_ReturnSavedProduct() {
        // Arrange
        Product product = Product.builder()
                .name("Iphhone 14")
                .price(1200)
                .quantity(100)
                .build();

        // Act test
        Product savedProduct = productRepository.save(product);

        // Assert
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void ProductRepository_GetAll_ReturnMoreThanOneProduct() {
        // Arrange
        Product product1 = Product.builder()
                .name("Iphone 14")
                .price(1200)
                .quantity(100)
                .build();
        Product product2 = Product.builder()
                .name("Macbook pro 13")
                .price(2500)
                .quantity(90)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

        // Act test
        List<Product> productList = productRepository.findAll();

        // Assert
        Assertions.assertThat(productList).isNotNull();
        Assertions.assertThat(productList.size()).isEqualTo(2);
    }

    @Test
    public void ProductRepository_FindById_ReturnProduct() {
        // Arrange
        Product product1 = Product.builder()
                .name("Iphone 14")
                .price(1200)
                .quantity(100)
                .build();

        productRepository.save(product1);

        // Act test
        Product foundProduct = productRepository.findById(product1.getId()).get();

        // Assert
        Assertions.assertThat(foundProduct).isNotNull();
    }
}
