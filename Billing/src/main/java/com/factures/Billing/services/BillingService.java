package com.factures.Billing.services;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;

import java.util.List;

public interface BillingService {
    BillingResponse save(BillingRequest req);
    BillingResponse getById(BillingRequest req);
    List<BillingResponse> getAllByCustomerId(BillingRequest req);
    List<BillingResponse> getAll();
    void delete(BillingRequest req);
}
