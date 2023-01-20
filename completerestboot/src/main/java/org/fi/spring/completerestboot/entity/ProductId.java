package org.fi.spring.completerestboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductId implements Serializable
{
	private static final long serialVersionUID = -2114659809239530303L;

	@Column(name="categoryid")
	int categoryId;
	
	@Column(name="productid")
	String productId;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
