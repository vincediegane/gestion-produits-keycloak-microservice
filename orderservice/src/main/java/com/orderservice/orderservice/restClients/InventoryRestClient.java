package com.orderservice.orderservice.restClients;

import com.orderservice.orderservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081", name = "inventory-service")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    public List<Product> getAllProducts();
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable String id);
}
