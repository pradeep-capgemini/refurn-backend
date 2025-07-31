package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.Product;
import com.capgemini.repository.ProductRepository;

public interface ProductService 
{
	List<Product> getAllProducts();

	Optional<Product> getProductById(Long id);

	Product saveProduct(Product product);
}
