package com.capgemini.entity;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private Long cartProductId;
    private String cartProductTitle;
    private double cartProductRating;
    private int cartProductReviews;
    private String cartProductDescription;
    private double cartProductPrice;
    private double cartProductDiscount;
    private String cartProductImage;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(Long cartProductId) {
		this.cartProductId = cartProductId;
	}
	public String getCartProductTitle() {
		return cartProductTitle;
	}
	public void setCartProductTitle(String cartProductTitle) {
		this.cartProductTitle = cartProductTitle;
	}
	public double getCartProductRating() {
		return cartProductRating;
	}
	public void setCartProductRating(double cartProductRating) {
		this.cartProductRating = cartProductRating;
	}
	public int getCartProductReviews() {
		return cartProductReviews;
	}
	public void setCartProductReviews(int cartProductReviews) {
		this.cartProductReviews = cartProductReviews;
	}
	public String getCartProductDescription() {
		return cartProductDescription;
	}
	public void setCartProductDescription(String cartProductDescription) {
		this.cartProductDescription = cartProductDescription;
	}
	public double getCartProductPrice() {
		return cartProductPrice;
	}
	public void setCartProductPrice(double cartProductPrice) {
		this.cartProductPrice = cartProductPrice;
	}
	public double getCartProductDiscount() {
		return cartProductDiscount;
	}
	public void setCartProductDiscount(double cartProductDiscount) {
		this.cartProductDiscount = cartProductDiscount;
	}
	public String getCartProductImage() {
		return cartProductImage;
	}
	public void setCartProductImage(String cartProductImage) {
		this.cartProductImage = cartProductImage;
	}

    
}

