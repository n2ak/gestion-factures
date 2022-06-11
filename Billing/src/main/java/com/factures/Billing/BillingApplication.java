package com.factures.Billing;

import com.factures.Billing.entities.Bill;
import com.factures.Billing.entities.Customer;
import com.factures.Billing.entities.ProductItem;
import com.factures.Billing.repos.BillingRepo;
import com.factures.Billing.repos.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BillingApplication {

	public static void main(String[] args){
		SpringApplication.run(BillingApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BillingRepo billingRepo, ProductItemRepo productItemRepo){
		return args -> {
			List<ProductItem> items = new ArrayList<>();
			for (int j = 1; j <= 3; j++) {
				Bill saved = billingRepo.save(new Bill(-1L, (long) j,null,null));
				for (int i = 1; i <= 3; i++) {
					ProductItem item = new ProductItem(-1L, (long) i,saved.getId(),i*10L,300,null,null);
					productItemRepo.save(item);
					items.add(item);
				}
			}
		};
	}
}
