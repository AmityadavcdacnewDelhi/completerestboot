package org.fi.spring.completerestboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="category_1234")
	public class Category 
	{
		@Id
		@GeneratedValue(generator="increment")
		@Column(name="categoryid")
		int categoryId;
		
		@Column(name="categoryname")
		String categoryName;
		
		@Column(name="categorydescription")
		String categoryDescription;
		
		@Column(name="categoryimageurl")
		String categoryImageUrl;

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getCategoryDescription() {
			return categoryDescription;
		}

		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}

		public String getCategoryImageUrl() {
			return categoryImageUrl;
		}

		public void setCategoryImageUrl(String categoryImageUrl) {
			this.categoryImageUrl = categoryImageUrl;
		}
		
	}
