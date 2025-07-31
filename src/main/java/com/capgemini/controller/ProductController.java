package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.capgemini.entity.Product;
import com.capgemini.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/refurn")
public class ProductController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		try {
			String productJson = objectMapper.writeValueAsString(product);
			kafkaTemplate.send("product-submission-topic", productJson);
			return ResponseEntity.ok("Product submitted for approval");
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending product");
		}
	}

	@GetMapping("/approved")
	public ResponseEntity<List<Product>> getApprovedProducts() {
		return ResponseEntity.ok(productService.getApprovedProducts());
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchProducts(@RequestParam(required = false) String query) {
		if (query == null || query.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Query parameter must not be null or empty");
		}

		List<Product> results = productService.searchProducts(query.trim());
		return ResponseEntity.ok(results);
	}

}
