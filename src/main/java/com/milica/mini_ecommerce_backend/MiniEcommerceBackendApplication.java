package com.milica.mini_ecommerce_backend;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.milica.mini_ecommerce_backend.Model.Cart;
import com.milica.mini_ecommerce_backend.Model.CartItem;
import com.milica.mini_ecommerce_backend.Model.Product;
import com.milica.mini_ecommerce_backend.Repository.CartItemRepository;
import com.milica.mini_ecommerce_backend.Repository.CartRepository;
import com.milica.mini_ecommerce_backend.Repository.ProductRepository;

@SpringBootApplication
public class MiniEcommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniEcommerceBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepository, CartRepository cartRepository,
			CartItemRepository cartItemRepository) {
		return args -> {
			Product p1 = new Product();
			p1.setName("Laptop");
			productRepository.save(p1);

			Product p2 = new Product();
			p2.setName("Phone");
			productRepository.save(p2);

			Cart cart = new Cart();
			cart.setUserId(1);
			if (cart.getCartItems() == null) {
				cart.setCartItems(new ArrayList<>());
			}

			CartItem cartItem1 = new CartItem();
			cartItem1.setProduct(p1);
			cartItem1.setQuantity(2);
			cartItem1.setCart(cart);
			cart.getCartItems().add(cartItem1);

			CartItem cartItem2 = new CartItem();
			cartItem2.setProduct(p2);
			cartItem2.setQuantity(1);
			cartItem2.setCart(cart);
			cart.getCartItems().add(cartItem2);

			cartRepository.save(cart);

		};
	}

}
