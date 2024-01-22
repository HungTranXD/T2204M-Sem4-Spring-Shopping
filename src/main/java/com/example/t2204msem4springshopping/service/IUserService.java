package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    User updateUser(User user);

    void deleteUser(Long userId);
}
