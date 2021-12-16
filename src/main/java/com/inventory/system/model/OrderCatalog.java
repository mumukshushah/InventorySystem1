package com.inventory.system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class OrderCatalog {
	@Id
	@GeneratedValue
	private int orderId;
	private String customerName;
	private String emailId;
	
	@ManyToMany
	@JoinTable(
			  name = "order_product", 
			  joinColumns = @JoinColumn(name = "order_id"), 
			  inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<ProductCatalog> productSet=new HashSet<>();
	
	
	public Set<ProductCatalog> getProductSet() {
		return productSet;
	}
	public void addProductSet(ProductCatalog product) {
		productSet.add(product);
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", emailId=" + emailId + "]";
	}

}
