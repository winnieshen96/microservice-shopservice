package com.microservice.project4.shopservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ShopConfig {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
