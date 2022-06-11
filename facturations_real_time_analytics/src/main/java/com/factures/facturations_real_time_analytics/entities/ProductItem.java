package com.factures.facturations_real_time_analytics.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    private Long id;
    private Long productId;
    private Long quantity;
    private double price;
}
