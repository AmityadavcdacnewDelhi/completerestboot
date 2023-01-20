package org.fi.spring.completerestboot.repositories;

import java.util.List;

import org.fi.spring.completerestboot.entity.Product;
import org.fi.spring.completerestboot.entity.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository 
			extends JpaRepository<Product, ProductId> 
{
	@Query(value="select objProduct from Product objProduct where objProduct.id.categoryId=:categoryId")
	public List<Product> getAllProductByCategoryId(@Param("categoryId")int categoryId);
}
