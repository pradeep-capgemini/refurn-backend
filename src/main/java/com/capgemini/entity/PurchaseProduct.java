package com.capgemini.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    private Long purchaseProductId;
    private String purchaseTitle;
    private String purchaseDescription;
    private Double purchasePrice;
    private String purchaseQuantity;
    private Double purchaseDiscount;
    private String purchaseImage;
    private String userName;
    private String purchaseAddress;
    private LocalDateTime purchaseDate;
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Long getPurchaseProductId() {
		return purchaseProductId;
	}
	public void setPurchaseProductId(Long purchaseProductId) {
		this.purchaseProductId = purchaseProductId;
	}
	public String getPurchaseTitle() {
		return purchaseTitle;
	}
	public void setPurchaseTitle(String purchaseTitle) {
		this.purchaseTitle = purchaseTitle;
	}
	public String getPurchaseDescription() {
		return purchaseDescription;
	}
	public void setPurchaseDescription(String purchaseDescription) {
		this.purchaseDescription = purchaseDescription;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getPurchaseDiscount() {
		return purchaseDiscount;
	}
	public void setPurchaseDiscount(Double purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}
	public String getPurchaseImage() {
		return purchaseImage;
	}
	public void setPurchaseImage(String purchaseImage) {
		this.purchaseImage = purchaseImage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPurchaseAddress() {
		return purchaseAddress;
	}
	public void setPurchaseAddress(String purchaseAddress) {
		this.purchaseAddress = purchaseAddress;
	}
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
    
    

   
}

