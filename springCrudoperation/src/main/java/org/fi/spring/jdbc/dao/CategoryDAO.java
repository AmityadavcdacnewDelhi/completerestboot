package org.fi.spring.jdbc.dao;

import java.util.List;

import org.fi.spring.beans.Category;

 public interface CategoryDAO {
 public boolean addCategory(Category objcategory);
 public List<Category> getAllCategory();
 public boolean updateCategory(int catId, String catName, String catDescription,String catImageUrl);
 public boolean deleteCategory(int categoryId);

}

