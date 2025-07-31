package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.SellingHistoryDTO;
import com.capgemini.service.ProductService;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/{sellerId}/selling-history")
//    public ResponseEntity<?> getSellingHistory(@PathVariable Long sellerId) {
//        List<SellingHistoryDTO> history = productService.getSellingHistory(sellerId);
//        return ResponseEntity.ok(history);
//    }
}

