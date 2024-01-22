package com.example.t2204msem4springshopping.repository;

import com.example.t2204msem4springshopping.entity.OrderProduct;
import com.example.t2204msem4springshopping.entity.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}
