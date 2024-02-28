package com.orderservice.orderservice.service;

import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> findAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order findOrderById(String id) {
        return orderRepository.findById(id).get();
    }
}
