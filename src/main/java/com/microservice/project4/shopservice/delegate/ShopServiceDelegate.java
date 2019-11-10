package com.microservice.project4.shopservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.project4.shopservice.client.InventoryClient;

@Service
public class ShopServiceDelegate {

	@Autowired
    RestTemplate restTemplate;
	@Autowired
	InventoryClient inventoryClient;
     
    public String callInventoryServiceAndGetData(String shopName) {
    	
        System.out.println("Getting shop details for " + shopName);
 
        String response = inventoryClient.getInventory(shopName).toString();
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Shop Name -  " + shopName + " :::  Inventory Details " + response + " -  " + new Date();
    }
     
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
