package com.milica.mini_ecommerce_backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milica.mini_ecommerce_backend.Model.Cart;
import com.milica.mini_ecommerce_backend.Model.CartItem;
import com.milica.mini_ecommerce_backend.Repository.CartItemRepository;
import com.milica.mini_ecommerce_backend.Repository.CartRepository;
import com.milica.mini_ecommerce_backend.Repository.ProductRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;

    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartByUserId(Integer userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found by user " + userId));
    }

    public CartItem addItemToCart(Integer userId, Integer productId, Integer quantity) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user " + userId));

        var product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));

        CartItem existingItem = cart.getCartItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            return cartItemRepository.save(existingItem);
        }

        CartItem newItem = new CartItem();
        newItem.setCart(cart);
        newItem.setProduct(product);
        newItem.setQuantity(quantity);

        cart.getCartItems().add(newItem);
        cartRepository.save(cart);

        return cartItemRepository.save(newItem);
    }

    public CartItem updateCartItemQuantity(Integer cartItemId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found with id " + cartItemId));

        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    public boolean removeItemFromCart(Integer cartItemId) {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new RuntimeException("CartItem not found with id " + cartItemId);
        }
        cartItemRepository.deleteById(cartItemId);
        return true;
    }
}
