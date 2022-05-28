package com.factures.Billing.services;

import com.factures.Billing.entities.Bill;
import com.factures.Billing.repos.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class BillingService {

    @Autowired
    private BillingRepo repo;

    public void register(Bill c){
        repo.save(c);
    }

}
