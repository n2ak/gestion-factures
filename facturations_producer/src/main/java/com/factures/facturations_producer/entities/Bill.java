package com.factures.facturations_producer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    private Long id;
    private Long customerId;
    private List<ProductItem> productItems;
}

