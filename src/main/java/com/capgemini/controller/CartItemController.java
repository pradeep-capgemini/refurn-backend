package com.capgemini.controller;


import org.springframework.web.bind.annotation.*;

import com.capgemini.entity.CartItem;
import com.capgemini.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/api/refurn/cart")
@CrossOrigin(origins = "http://localhost:4200") // Enable CORS for Angular
public class CartItemController {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return service.save(item);
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return service.getAll();
    }
}

