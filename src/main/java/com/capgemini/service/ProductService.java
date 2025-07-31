package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dto.SellingHistoryDTO;
import com.capgemini.entity.Product;
import com.capgemini.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getApprovedProducts() {
		return productRepository.findAll();
	}

	public List<Product> searchProducts(String query) {
		if (query == null || query.trim().isEmpty()) {
			throw new IllegalArgumentException("Query parameter must not be null or empty");
		}

		return productRepository.findByProductNameContainingIgnoreCase(query.trim());
	}
	
//	public List<SellingHistoryDTO> getSellingHistory(Long sellerId) {
//        return productRepository.getSellingHistoryBySeller(sellerId);
//    }


}
