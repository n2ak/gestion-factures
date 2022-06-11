package com.factures.batchprecessing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Bill {
    private Long id;
    private Long customerId;
    private List<ProductItem> productItems;
}
