package com.milica.mini_ecommerce_backend.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milica.mini_ecommerce_backend.Model.CartItem;
import com.milica.mini_ecommerce_backend.Service.CartItemService;

@RestController
@RequestMapping("api/cartitem")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }
}
