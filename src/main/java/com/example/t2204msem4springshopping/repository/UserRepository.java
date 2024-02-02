package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
