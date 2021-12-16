package com.inventory.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.dao.ProductCatalogRepo;
import com.inventory.system.model.ProductCatalog;

@RestController
public class InventoryRestController {
	
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@GetMapping("/products")
	public List<ProductCatalog> getAllProducts(){
		
		return productCatalogRepo.findAll();
	}
	
	@GetMapping("/products/{category}")
	public List<ProductCatalog> getAllProductsBasedOnCategory(@PathVariable("category") String category){
		
		return productCatalogRepo.findByCategory(category);
	}

}
