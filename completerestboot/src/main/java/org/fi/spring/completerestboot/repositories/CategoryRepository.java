package org.fi.spring.completerestboot.repositories;

import org.fi.spring.completerestboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
