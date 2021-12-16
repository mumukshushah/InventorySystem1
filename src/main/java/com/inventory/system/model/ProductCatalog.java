package com.inventory.system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProductCatalog {
	
	@Id
	private int productId;
	private String artistName;
	private int price;
	private String productName;
	private String category;
	
	@ManyToMany(mappedBy="productSet")
	Set<OrderCatalog> orderSet = new HashSet<>();
	
	public Set<OrderCatalog> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<OrderCatalog> orderSet) {
		this.orderSet = orderSet;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", artistName=" + artistName + ", price=" + price + ", productName="
				+ productName + ", category=" + category + "]";
	}


}
