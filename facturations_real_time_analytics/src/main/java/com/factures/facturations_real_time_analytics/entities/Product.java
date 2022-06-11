package com.factures.facturations_real_time_analytics.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Product {
    private Long id;
    private String name;
    private double price;
}
