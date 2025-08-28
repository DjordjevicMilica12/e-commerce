package com.milica.mini_ecommerce_backend.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milica.mini_ecommerce_backend.Model.Cart;
import com.milica.mini_ecommerce_backend.Model.CartItem;
import com.milica.mini_ecommerce_backend.Service.CartService;

@RequestMapping("api/cart")
@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/all")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping
    public Cart getCartByUserId(@RequestParam Integer userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/add")
    public CartItem addItemToCart(@RequestParam Integer userId,
            @RequestParam Integer productId,
            @RequestParam Integer quantity) {
        return cartService.addItemToCart(userId, productId, quantity);
    }

    @PutMapping("/update")
    public CartItem updateCartItemQuantity(@RequestBody Integer cartItemId,
            @RequestBody Integer quantity) {
        return cartService.updateCartItemQuantity(cartItemId, quantity);
    }

    @DeleteMapping("/remove")
    public boolean removeItemFromCart(@RequestParam Integer cartItemId) {
        return cartService.removeItemFromCart(cartItemId);
    }
}
