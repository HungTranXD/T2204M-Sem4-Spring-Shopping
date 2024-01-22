package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
