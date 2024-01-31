package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.Category;
import com.example.t2204msem4springshopping.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void ProductRepository_SaveAll_ReturnSavedProduct() {
        // Arrange
        Product product = new Product("Test Product", 100, 10, new Category("Test Category"));

        // Act test


        // Assert
    }
}
