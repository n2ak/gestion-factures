package com.factures.Billing.dto;

import com.factures.Billing.entities.ProductItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingRequest {
    private Long id;
    private Long customerId;
    private List<ProductItem> productItems;
}
