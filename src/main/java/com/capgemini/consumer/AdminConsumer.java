package com.capgemini.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Product;
import com.capgemini.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AdminConsumer {
	private static final Logger logger = LoggerFactory.getLogger(AdminConsumer.class);
	
	@Autowired
	private ProductRepository productRepository;

    @KafkaListener(topics = "product-submission-topic", groupId = "admin-group")
    public void listen(String productJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(productJson, Product.class);
        //need to save the product data in db coming from seller
        productRepository.save(product);
        logger.info("Admin received product for approval: " + product.getProductTitle());
    }
}
