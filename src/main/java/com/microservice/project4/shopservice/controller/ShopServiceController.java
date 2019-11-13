package com.microservice.project4.shopservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project4.shopservice.client.InventoryClient;

@RestController
public class ShopServiceController {

	@Autowired
	InventoryClient inventoryClient;
	
    //The annotation of RequestMapping can map HTTP request 
    //"http://host:port/" to this method
    @RequestMapping("/")
    public String home() {
        return "Welcome to shop service";
    }
    
    @RequestMapping(value = "/getShopDetails/{shopName}", method = RequestMethod.GET)
    public String getInventory(@PathVariable String shopName) {
    	
        System.out.println("Going to call inventory service to get data!");
        System.out.println("Getting shop details for " + shopName);
        
        String response = inventoryClient.getInventory(shopName).toString();
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Shop Name -  " + shopName + " :::  Inventory Details " + response + " -  " + new Date();
    }
}
