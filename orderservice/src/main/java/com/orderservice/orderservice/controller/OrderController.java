package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.restClients.InventoryRestClient;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;
    private InventoryRestClient inventoryRestClient;

    public OrderController(OrderService orderService, InventoryRestClient inventoryRestClient) {
        this.orderService = orderService;
        this.inventoryRestClient = inventoryRestClient;
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('USER')")
    public List<Order> findAllOrders() {
        List<Order> allOrders = this.orderService.findAllOrders();
        allOrders.forEach(o -> {
            o.getProductItems().forEach(pi -> {
                pi.setProduct(inventoryRestClient.getProductById(pi.getProductId()));
            });
        });
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Order findOrderById(@PathVariable String id) {
        Order order = orderService.findOrderById(id);
        order.getProductItems().forEach(pi -> {
            pi.setProduct(inventoryRestClient.getProductById(pi.getProductId()));
        });
        return order;
    }
}
