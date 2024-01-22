package com.example.t2204msem4springshopping.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id; // Use EmbeddedId for composite primary key

    @ManyToOne
    @MapsId("orderId") // Map part of the EmbeddedId to the foreign key column
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId") // Map part of the EmbeddedId to the foreign key column
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Integer quantity, Double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

