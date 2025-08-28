package com.milica.mini_ecommerce_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milica.mini_ecommerce_backend.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUserId(Integer userId);
}
