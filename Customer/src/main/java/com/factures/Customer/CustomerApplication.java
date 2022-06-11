package com.factures.Customer;

import com.factures.Customer.entities.Customer;
import com.factures.Customer.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication {

	public static void main(String[] args){
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Autowired private CustomerRepo customerRepo;

	@Bean
	CommandLineRunner run(){
		return args -> {
			for (int i = 1; i <= 5; i++) {
				customerRepo.save(new Customer((long)-1,"customer"+i,"customer"+i+"@gmail.com"));
			}
		};
	}
}
