package com.microservice.project4.shopservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopServiceDelegate {

	@Autowired
    RestTemplate restTemplate;
     
    public String callInventoryServiceAndGetData(String shopName) {
    	
        System.out.println("Getting shop details for " + shopName);
 
	String resourceUrl = "http://inventory-service:6500/getInventoryForShop/" + shopName;
	ResponseEntity<String> response
				= restTemplate.getForEntity(resourceUrl, String.class);
        
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Shop Name -  " + shopName + " :::  Inventory Details " + response + " -  " + new Date();
    }
     
}
