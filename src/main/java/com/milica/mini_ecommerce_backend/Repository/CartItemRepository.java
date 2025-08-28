package com.milica.mini_ecommerce_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milica.mini_ecommerce_backend.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
