package com.factures.facturations_consumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    private String id;
    private String productId;
    private Long quantity;
    private double price;
}
