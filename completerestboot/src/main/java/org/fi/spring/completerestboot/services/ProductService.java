package org.fi.spring.completerestboot.services;

import java.util.List;

import org.fi.spring.completerestboot.dto.ProductDTO;
import org.fi.spring.completerestboot.dto.ProductIdDTO;

public interface ProductService 
{
	public ProductDTO getProductById(ProductIdDTO pid);
	
	public List<ProductDTO> getAllProducts(int categoryId);
	
	public boolean addNewProduct(ProductDTO objProduct);
	
	
}
