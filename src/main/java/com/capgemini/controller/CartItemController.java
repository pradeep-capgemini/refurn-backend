package com.capgemini.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.ApiResponse;
import com.capgemini.dto.PurchaseResponse;
import com.capgemini.entity.CartItem;
import com.capgemini.service.CartItemService;


import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/refurn/cart")
public class CartItemController {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return service.save(item);
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return service.getAll();
    }
    

	@GetMapping("/{username}")
	public ResponseEntity<List<CartItem>> getCartByUsername(@PathVariable String username) {
		List<CartItem> cartItems = service.getCartItemsByUsername(username);
		return ResponseEntity.ok(cartItems);
	}


//	@DeleteMapping("/{productId}")
//	    public ResponseEntity<String> removeProduct(@PathVariable Long productId) {
//	        boolean removed = service.removeProductById(productId);
//	        if (removed) {
//	            return ResponseEntity.ok("Product removed successfully");
//	        } else {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
//	        }
//	    }
	
//	@DeleteMapping("/{productId}")
//	public ResponseEntity<ApiResponse> removeProduct(@PathVariable Long productId) {
//	    boolean removed = service.removeProductById(productId);
//	    if (removed) {
//	        return ResponseEntity.ok(new ApiResponse(true, "Product removed successfully"));
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//	                             .body(new ApiResponse(false, "Product not found"));
//	    }
//	}

	@DeleteMapping("/remove")
	public ResponseEntity<ApiResponse> removeProduct(
	        @RequestParam String cartUserName,
	        @RequestParam Long cartProductId) {

	    boolean removed = service.removeProduct(cartUserName, cartProductId);

	    if (removed) {
	        return ResponseEntity.ok(new ApiResponse(true, "Product removed successfully"));
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body(new ApiResponse(false, "Product not found"));
	    }
	}

//	@PostMapping("/buy")
//	public ResponseEntity<PurchaseResponse> buyProduct(@RequestBody CartItem cartItem) {
//		System.out.println(cartItem.toString());
//		PurchaseResponse response = new PurchaseResponse("success", "Purchase successful");
//		return ResponseEntity.ok(response);
//
//	}
	

		@PostMapping("/buy")
		public ResponseEntity<PurchaseResponse> buyProduct(@RequestBody CartItem cartItem) {
			service.savePurchase(cartItem);
		    PurchaseResponse response = new PurchaseResponse("success", "Purchase successful");
		    return ResponseEntity.ok(response);
		}

	
}

