package com.factures.Inventory;

import com.factures.Inventory.entities.Product;
import com.factures.Inventory.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryApplication {

	public static void main(String[] args){
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Autowired
	private InventoryRepo inventoryRepo;

	@Bean
	CommandLineRunner run(){
		return args -> {
			for (int i = 1; i <= 10; i++) {
				inventoryRepo.save(new Product((long)-1,"product"+i,new Random().nextDouble()*1000));
			}
		};
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
