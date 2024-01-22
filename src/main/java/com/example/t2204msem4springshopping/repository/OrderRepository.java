package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
