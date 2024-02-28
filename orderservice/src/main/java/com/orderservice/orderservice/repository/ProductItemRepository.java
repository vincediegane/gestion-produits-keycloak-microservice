package com.orderservice.orderservice.repository;

import com.orderservice.orderservice.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
