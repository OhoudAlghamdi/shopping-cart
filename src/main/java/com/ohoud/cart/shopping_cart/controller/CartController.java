package com.ohoud.cart.shopping_cart.controller;

import com.ohoud.cart.shopping_cart.model.Cart;
import com.ohoud.cart.shopping_cart.model.Order;
import com.ohoud.cart.shopping_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam int productId, @RequestParam int quantity) {
        cartService.addProduct(productId, quantity);
        return "Product added to cart";
    }

    @GetMapping
    public Cart viewCart() {
        return cartService.getCart();
    }

    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared";
    }
    
    @PostMapping("/checkout")
    public Order checkout() {
        return cartService.checkout();
    }
}