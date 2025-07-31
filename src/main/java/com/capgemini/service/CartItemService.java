package com.capgemini.service;

import org.springframework.stereotype.Service;

import com.capgemini.entity.CartItem;
import com.capgemini.repository.CartItemRepository;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    public CartItem save(CartItem item) {
        return repository.save(item);
    }

    public List<CartItem> getAll() {
        return repository.findAll();
    }
}

