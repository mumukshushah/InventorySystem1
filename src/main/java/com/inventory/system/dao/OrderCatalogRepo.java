package com.inventory.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.system.model.OrderCatalog;

public interface OrderCatalogRepo extends JpaRepository<OrderCatalog, Integer> {

}
