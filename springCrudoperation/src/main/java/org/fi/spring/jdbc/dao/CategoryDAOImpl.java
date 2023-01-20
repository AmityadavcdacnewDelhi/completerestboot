package org.fi.spring.jdbc.dao;


import java.util.List;

import javax.annotation.PostConstruct;

import org.fi.spring.beans.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
@Component
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sqlInsertCategory;
	String sqlDelteCategory;
	String sqlUpdateCategory;
	String sqlAllCategories;
	@Autowired
	Environment environment;
	@PostConstruct
	public void initCategoryDAO()
	{
		 sqlInsertCategory =environment.getProperty("sql.insertCategory");
		 sqlDelteCategory =environment.getProperty("sql.deleteCategory");
		 sqlUpdateCategory =environment.getProperty("sql.updateCategory");
		 sqlAllCategories =environment.getProperty("sql.allCategories");
	}

	

	@Override
	public boolean addCategory(Category objcategory) {
		int count = jdbcTemplate.update(sqlInsertCategory,
				objcategory.getCategoryId(),
				objcategory.getCategoryName(),
				objcategory.getCategoryDescription(),
				objcategory.getCategoryImageUrl());
		if(count>0)
			return true;
		else
		return false;
		
	}

	@Override
	public List<Category> getAllCategory()
	{
		return jdbcTemplate.query(sqlAllCategories, new CategoryMapper());
		 
		      
	        
	}

	@Override
	public boolean updateCategory(int catId, String catName, String catDescription, String catImageUrl) {
		int count = jdbcTemplate.update(sqlUpdateCategory,catName ,catDescription,catImageUrl,catId);
		if(count>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean deleteCategory(int categoryId) 
	 {
		
		int count= jdbcTemplate.update(sqlDelteCategory,categoryId);
		return true;
		
	    }
}





