package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	

    List<CartItem> findByCartUserName(String cartUserName);
    
    List<CartItem> findAllByCartProductIdAndCartUserName(Long productId, String username);



}
