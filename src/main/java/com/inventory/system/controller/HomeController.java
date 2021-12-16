package com.inventory.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.system.dao.OrderCatalogRepo;
import com.inventory.system.dao.ProductCatalogRepo;
import com.inventory.system.model.OrderCatalog;
import com.inventory.system.model.ProductCatalog;

@Controller
public class HomeController {
	
	@Autowired
	ProductCatalogRepo productCatalogRepo;
	
	@Autowired
	OrderCatalogRepo orderCatalogRepo;
	

	@RequestMapping("/")
	public ModelAndView selectCategory() {
		List<String> categoryList = productCatalogRepo.findAllDistinctCategory();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SelectCategory.jsp");
		mv.addObject("distinctCategoryList",categoryList);
		
		return mv;
	}
	
	@RequestMapping("/see-products")
	public ModelAndView seeProducts(@RequestParam("category") String category,@RequestParam("email") String email,@RequestParam("name") String name) {
		List<ProductCatalog> productList = productCatalogRepo.findByCategory(category);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListProduct.jsp");
		mv.addObject("productList",productList);
		mv.addObject("name",name);
		mv.addObject("email",email);
	
		return mv;	
		
	}
	
	@RequestMapping("/book-order")
	public String bookOrder(@RequestParam(value="product",required=false) List<Integer> productList,OrderCatalog orderCatalog) {	
		if(productList == null)
			return "BookFailure.jsp";
		
		for(int productId: productList) {
			ProductCatalog product= productCatalogRepo.findById(productId).get();
			orderCatalog.addProductSet(product);
		}
		System.out.println(orderCatalog.getProductSet());
		orderCatalogRepo.save(orderCatalog);
		return "BookSuccess.jsp";		
	}
}
