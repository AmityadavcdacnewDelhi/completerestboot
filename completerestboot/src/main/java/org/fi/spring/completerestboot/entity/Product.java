package org.fi.spring.completerestboot.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products_1234")
public class Product 
{
	@EmbeddedId
	ProductId id;
	
	@Column(name="productname")
	String productName;
	
	@Column(name="productdescription")
	String productDescription;
	
	@Column(name="productprice")
	String productPrice;
	
	
	@Column(name="productimageurl")
	String productImageUrl;


	public ProductId getId() {
		return id;
	}


	public void setId(ProductId id) {
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
