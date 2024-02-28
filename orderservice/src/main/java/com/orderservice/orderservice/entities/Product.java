package com.orderservice.orderservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String userId;
}
