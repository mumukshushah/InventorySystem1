package com.inventory.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.system.model.ProductCatalog;

public interface ProductCatalogRepo extends JpaRepository<ProductCatalog, Integer> {
	
	
	List<ProductCatalog> findByCategory(String category); 
	
	@Query(value = "select distinct category from ProductCatalog order by category")
	List<String> findAllDistinctCategory();

}
