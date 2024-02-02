package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.Role;
import com.example.t2204msem4springshopping.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("user@email.com");
        user.setPassword("password");
        user.setFirstName("John");
        user.setLastName("Doe");

        User savedUser = repository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        Assert.assertEquals(user.getEmail(), existUser.getEmail());
    }

    @Test
    public void testGetUserByEmail() {
        Optional<User> user = repository.findByEmail("user@email.com");
        if (user.isEmpty()) return;

        Assertions.assertEquals(user.get().getEmail(), "user@email.com");
    }
}
