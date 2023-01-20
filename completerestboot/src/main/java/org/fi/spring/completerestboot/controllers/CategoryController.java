package org.fi.spring.completerestboot.controllers;

import java.io.Serializable;
import java.util.List;

import org.fi.spring.completerestboot.dto.CategoryDTO;
import org.fi.spring.completerestboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public Serializable addNew(@RequestBody CategoryDTO objCategory)
	{
		return categoryService.addNew(objCategory);
	}
	
	@GetMapping("/get/{cid}")
	public CategoryDTO getCategory(@PathVariable("cid")int categoryId)
	{
		return categoryService.getCategory(categoryId);
	}
	@GetMapping("getAll")
	public List<CategoryDTO> getCategory()
	{
		return categoryService.getCategory();
	}

}
