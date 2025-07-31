package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
