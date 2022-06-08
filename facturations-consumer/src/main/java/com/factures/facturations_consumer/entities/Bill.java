package com.factures.facturations_consumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor public class Bill {
    private String id;
    private String customerId;
    private List<ProductItem> productItems;
}
