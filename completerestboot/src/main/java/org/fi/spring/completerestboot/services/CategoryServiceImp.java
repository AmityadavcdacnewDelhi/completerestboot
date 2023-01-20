package org.fi.spring.completerestboot.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.fi.spring.completerestboot.dto.CategoryDTO;
import org.fi.spring.completerestboot.entity.Category;
import org.fi.spring.completerestboot.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImp implements CategoryService {
	 @Autowired
	CategoryRepository categoryRepository;
	@Override
	public Serializable addNew(CategoryDTO objCategory) {
		Category entityCategory = new Category();
          BeanUtils.copyProperties(objCategory, entityCategory);
		
		return categoryRepository.save(entityCategory).getCategoryId();
	}

	@Override
	public CategoryDTO getCategory(int categoryId) {
		Optional<Category> optCategory = categoryRepository.findById(categoryId);
		if(optCategory.isPresent())
		{
			Category entityCategory = optCategory.get();
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(entityCategory, dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CategoryDTO> getCategory() {
		Iterator<Category> iter = categoryRepository.findAll().iterator();
		ArrayList<CategoryDTO> list = new ArrayList<>();
		while(iter.hasNext())
		{
			Category entityCategory = iter.next();
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(entityCategory, dto);
			list.add(dto);
		}
		return list;
	}

}
