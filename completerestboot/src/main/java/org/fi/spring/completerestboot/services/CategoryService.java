package org.fi.spring.completerestboot.services;

import java.io.Serializable;
import java.util.List;

import org.fi.spring.completerestboot.dto.CategoryDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryService {
	// add new Category
	public Serializable addNew(@RequestBody CategoryDTO objCategory);
	
	//get by categoryId
	public CategoryDTO getCategory(@PathVariable("cid")int categoryId);
	
	//getAll category Items
	public List<CategoryDTO> getCategory();
	

	//uses the path variable to accept the mobile id and form data parameters using POST to update the details of that mobile with the help of Native Query in JPA Repository)
	
	


}
