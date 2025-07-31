package com.capgemini.dto;

import java.util.Date;

public class SellingHistoryDTO {
	private String productName;
	private Double productPrice;
	private Date sellingDate;
	private String productCategory;
	private Integer quantity;
	private byte[] imageData;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Date getSellingDate() {
		return sellingDate;
	}
	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public SellingHistoryDTO(String productName, Double productPrice, Date sellingDate, String productCategory,
			Integer quantity, byte[] imageData) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellingDate = sellingDate;
		this.productCategory = productCategory;
		this.quantity = quantity;
		this.imageData = imageData;
	}
	
	


}
