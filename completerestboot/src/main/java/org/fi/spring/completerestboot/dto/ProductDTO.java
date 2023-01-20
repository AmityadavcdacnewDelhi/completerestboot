package org.fi.spring.completerestboot.dto;

public class ProductDTO 
{
	ProductIdDTO id;
	
	String productName;
	
	String productDescription;
	
	String productPrice;
	
	String productImageUrl;

	public ProductIdDTO getId() {
		return id;
	}

	public void setId(ProductIdDTO id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	
}
