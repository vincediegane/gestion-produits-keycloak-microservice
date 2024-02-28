package com.inventoryservice;

import com.inventoryservice.entites.Product;
import com.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder().id("P01").name("Computer").price(2300).quantity(5).build());
			productRepository.save(Product.builder().id("P02").name("Printer").price(1200).quantity(10).build());
			productRepository.save(Product.builder().id("P03").name("Smartphone").price(4200).quantity(34).build());
		};
	}

}
