package com.orderservice.orderservice;

import com.orderservice.orderservice.entities.Product;
import com.orderservice.orderservice.enumeration.OrderState;
import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.model.ProductItem;
import com.orderservice.orderservice.repository.OrderRepository;
import com.orderservice.orderservice.repository.ProductItemRepository;
import com.orderservice.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrderRepository orderRepository,
				ProductItemRepository productItemRepository,
				InventoryRestClient inventoryRestClient) {
		return args -> {
//			List<Product> allProducts = inventoryRestClient.getAllProducts();
			List<String> allProducts = Arrays.asList("P01", "P02", "P03");
			for(int i = 0; i < 5; i++) {
                Order order = Order.builder()
						.id(UUID.randomUUID().toString())
						.date(LocalDate.now())
						.state(OrderState.PENDING)
						.build();
				Order savedOrder = orderRepository.save(order);
				allProducts.forEach(p -> {
					ProductItem productItem = ProductItem.builder()
							.productId(p)
							.quantity(new Random().nextInt(20))
							.price(new Random().nextInt(10000))
							.order(savedOrder)
							.build();
					productItemRepository.save(productItem);
				});
            }
		};
	}

}
