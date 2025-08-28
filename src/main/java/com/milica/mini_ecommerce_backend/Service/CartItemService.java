package com.milica.mini_ecommerce_backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milica.mini_ecommerce_backend.Model.CartItem;
import com.milica.mini_ecommerce_backend.Repository.CartItemRepository;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

}
