package com.factures.facturations_consumer.services;

import com.factures.facturations_consumer.entities.Bill;
import com.factures.facturations_consumer.feign.BillingService;
import com.factures.facturations_consumer.io.CsvWriter;
import com.factures.facturations_consumer.mappers.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class ConsumerService {
    @Autowired
    BillingService billingService;
    @Autowired
    BillMapper mapper;

    CsvWriter csvWriter;
    String filename = "bills_received.csv";

    @Bean
    public Consumer<Bill> billConsumer(){
        System.out.println("Waiting for bill messages:");
        csvWriter = new CsvWriter(filename);
        return (bill) -> {
            System.out.println("-Received message");
            billingService.addBill(mapper.billToBillRequest(bill));
            csvWriter.write(bill);
        };
    }
}
