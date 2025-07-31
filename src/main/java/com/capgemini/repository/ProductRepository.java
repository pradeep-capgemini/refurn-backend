package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.dto.SellingHistoryDTO;
import com.capgemini.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
//	    List<Product> findAllProduct();
	    List<Product> findByProductNameContainingIgnoreCase(String name);
	    
//	    List<SellingHistoryDTO> getSellingHistoryBySeller(@Param("sellerId") Long sellerId);

}
