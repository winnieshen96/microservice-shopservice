package com.microservice.project4.shopservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.project4.shopservice.domain.Good;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

	@GetMapping("/getInventoryForShop/{shopName}")
	List<Good> getInventory(@PathVariable String shopName);
	
}

