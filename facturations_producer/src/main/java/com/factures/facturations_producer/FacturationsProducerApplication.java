package com.factures.facturations_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class FacturationsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturationsProducerApplication.class, args);
	}

}
