package com.inventoryservice.service;

import com.inventoryservice.entites.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    // TODO: add other methods
}
