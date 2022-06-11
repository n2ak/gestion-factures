package com.factures.facturations_consumer;

import com.factures.facturations_consumer.entities.Bill;
import com.factures.facturations_consumer.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FacturationsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturationsConsumerApplication.class, args);
	}

}
