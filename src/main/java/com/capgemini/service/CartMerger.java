package com.capgemini.service;

import java.util.*;
import java.util.stream.Collectors;

import com.capgemini.entity.CartItem;

public class CartMerger {

    public static List<CartItem> mergeCartItems(List<CartItem> cartItems) {
        Map<Long, CartItem> mergedMap = new LinkedHashMap<>();

        for (CartItem item : cartItems) {
            Long productId = item.getCartProductId();
            if (mergedMap.containsKey(productId)) {
                CartItem existing = mergedMap.get(productId);
                int updatedQuantity = Integer.parseInt(existing.getCartProductQuantity()) +
                                      Integer.parseInt(item.getCartProductQuantity());
                existing.setCartProductQuantity(String.valueOf(updatedQuantity));
            } else {
                mergedMap.put(productId, new CartItem(item)); 
            }
        }

        return new ArrayList<>(mergedMap.values());
    }
}

