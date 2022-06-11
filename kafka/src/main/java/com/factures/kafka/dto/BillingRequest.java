package com.factures.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingRequest {
    private String id;
    private double price;
    private String customerId;
    private List<String> productItemsId;
}
