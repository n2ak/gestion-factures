package com.factures.Billing.dto;

import com.factures.Billing.entities.ProductItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingResponse {
    private String id;
    private double price;
    private String customerId;
    private List<String> productItemsId;
    @Transient
    private List<ProductItem> productItems;
}
