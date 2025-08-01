package com.capgemini.service;

import org.springframework.stereotype.Service;

import com.capgemini.entity.CartItem;
import com.capgemini.entity.PurchaseProduct;
import com.capgemini.repository.CartItemRepository;
import com.capgemini.repository.PurchaseProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    private final CartItemRepository repository;
    private final PurchaseProductRepository purchaseProductRepository;

    public CartItemService(CartItemRepository repository,PurchaseProductRepository purchaseProductRepository) {
        this.repository = repository;
        this.purchaseProductRepository = purchaseProductRepository;
    }

    public CartItem save(CartItem item) {
        return repository.save(item);
    }

    public List<CartItem> getAll() {
        return repository.findAll();
    }
    

	public List<CartItem> getCartItemsByUsername(String username) 
	{
	    
		List<CartItem> mergedCartList = CartMerger.mergeCartItems(repository.findByCartUserName(username));

		System.out.println(mergedCartList.toString());
		
		return mergedCartList;
	}
	
	
	public boolean removeProductById(Long cartId) {
	    Optional<CartItem> product = repository.findById(cartId);
	    if (product.isPresent()) {
	    	repository.deleteById(cartId);
	        return true;
	    }
	    return false;
	}

	
//	public boolean removeProduct(String cartUserName, Long cartProductId) {
//	    Optional<CartItem> productOptional = repository.findByCartUserNameAndCartProductId(cartUserName, cartProductId);
//
//	    if (productOptional.isPresent()) {
//	    	repository.delete(productOptional.get());
//	        return true;
//	    } else {
//	        return false;
//	    }
//	}

	public boolean removeProduct(String cartUserName, Long cartProductId) {
	    List<CartItem> items = repository.findAllByCartProductIdAndCartUserName(cartProductId, cartUserName);
	    if (!items.isEmpty()) {
	    	repository.deleteAll(items);
	        return true;
	    }
	    return false;
	}



    public void savePurchase(CartItem cartItem) {
        PurchaseProduct purchase = new PurchaseProduct();
        purchase.setPurchaseProductId(cartItem.getCartProductId());
        purchase.setPurchaseTitle(cartItem.getCartProductTitle());
        purchase.setPurchaseDescription(cartItem.getCartProductDescription());
        purchase.setPurchasePrice(cartItem.getCartProductPrice());
        purchase.setPurchaseQuantity(cartItem.getCartProductQuantity());
        purchase.setPurchaseDiscount(cartItem.getCartProductDiscount());
        purchase.setPurchaseImage(cartItem.getCartProductImage());
        purchase.setUserName(cartItem.getCartUserName());
        purchase.setPurchaseAddress(""); 
        purchase.setPurchaseDate(LocalDateTime.now());

        purchaseProductRepository.save(purchase);
    }


}

