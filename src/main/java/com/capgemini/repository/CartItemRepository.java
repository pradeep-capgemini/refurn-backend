package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
