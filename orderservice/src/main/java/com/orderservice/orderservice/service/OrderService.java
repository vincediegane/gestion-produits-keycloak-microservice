package com.orderservice.orderservice.service;

import com.orderservice.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order findOrderById(String id);
}
