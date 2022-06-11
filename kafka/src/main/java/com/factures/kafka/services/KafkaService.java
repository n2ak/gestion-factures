package com.factures.kafka.services;

import com.factures.kafka.entities.Bill;
import com.factures.kafka.mappers.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Consumer;

@Service
public class KafkaService {

    private final String TOPIC_NAME = "BILL_CREATION";
    @Autowired BillMapper mapper;
    @Autowired StreamBridge bridge;
    @Bean
    public Consumer<Bill> billCreation(){
        return (bill) -> {
            bridge.send(TOPIC_NAME,mapper.billToBillRequest(bill));
        };
    }
}
