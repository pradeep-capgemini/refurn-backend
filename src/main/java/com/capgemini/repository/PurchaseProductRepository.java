package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.PurchaseProduct;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {

}
