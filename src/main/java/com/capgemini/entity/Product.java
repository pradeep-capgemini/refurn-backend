package com.capgemini.entity;

import java.util.Date;

import com.capgemini.enums.ProductStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productTitle;
    private double productRating;
    private int productReviews;
    private String productDescription;
    private double productPrice;
    private String productDiscount;
    private byte[] productImage;
    private ProductStatus productStatus;
    private Date createdAt;
    private String productSellerName;

    public Product() {}
    
	public Product(Long productId, String productTitle, double productRating, int productReviews,
			String productDescription, double productPrice, String productDiscount, byte[] productImage) {
		this.productId = productId;
		this.productTitle = productTitle;
		this.productRating = productRating;
		this.productReviews = productReviews;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productImage = productImage;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public int getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(int productReviews) {
		this.productReviews = productReviews;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getProductSellerName() {
		return productSellerName;
	}

	public void setProductSellerName(String productSellerName) {
		this.productSellerName = productSellerName;
	}   
	
	

}

